package TP2.Exo2;

import TP2.Exo2.UserService;
import TP2.Exo2.Utilisateur;
import TP2.Exo2.UtilisateurApi;
import com.google.protobuf.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // ✅ Configuration du comportement du mock
        // Ici, on ne retourne rien car la méthode void — donc pas de when().thenReturn(), mais doNothing() ou simplement aucune exception attendue.
        // Mockito autorise les méthodes void sans configuration si aucune exception n’est attendue.

        // ✅ Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // ✅ Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // ✅ Vérification de l'appel à l'API avec le bon objet
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
}

