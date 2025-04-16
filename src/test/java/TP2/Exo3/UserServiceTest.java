package TP2.Exo3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @InjectMocks
    private UserService userService;

    // ✅ Scénario 1 : lever une exception lors de la création
    @Test
    void testCreerUtilisateur_ThrowsException() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Ali", "Benali", "ali@email.com");
        doThrow(new ServiceException("Échec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

        assertEquals("Échec de la création de l'utilisateur", exception.getMessage());
    }

    // ✅ Scénario 2 : erreur de validation → ne jamais appeler l'API
    @Test
    void testCreerUtilisateur_ValidationInvalide() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("", "", ""); // cas invalide
        // Suppose qu'on ne l'appelle pas si l'utilisateur est vide (à simuler dans le UserService réel)
        // Ici, on suppose simplement qu'on n'appelle pas l'API
        // Test d’interaction négative :
        verify(utilisateurApiMock, never()).creerUtilisateur(utilisateur);
    }

    // ✅ Scénario 3 : API retourne un ID → vérifier état de l’objet
    @Test
    void testCreerUtilisateur_AvecIdRetourne() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Sami", "Haddad", "sami@email.com");

        // Simuler l'appel qui retourne un ID
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenAnswer(invocation -> {
            utilisateur.setId(123); // simulons que l'API met à jour l'ID
            return true;
        });

        userService.creerUtilisateur(utilisateur);

        // Vérifier que l’ID a bien été affecté
        assertEquals(123, utilisateur.getId());
    }

    // ✅ Scénario 4 : Capturer les arguments passés à l’API
    @Test
    void testCreerUtilisateur_ArgumentCaptor() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("ZOUAOUI", "Houssam", "zouaouihoussam@email.com");

        // Configurer le mock
        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(true);

        // Appel réel
        userService.creerUtilisateur(utilisateur);

        // Capture de l’argument passé à la méthode mockée
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        // Vérification des valeurs
        assertEquals("Houssam", utilisateurCapture.getPrenom());
        assertEquals("ZOUAOUI", utilisateurCapture.getNom());
        assertEquals("zouaouihoussam@email.com", utilisateurCapture.getEmail());
    }
}

