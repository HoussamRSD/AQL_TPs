package TP3.Partie1.Exo1;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    void testGetUserById() {
        // Créer un mock pour UserRepository
        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepositoryMock);

        // Définir le comportement du mock
        long userId = 1L;
        User expectedUser = new User(userId, "Houssam ZOUAOUI");
        when(userRepositoryMock.findUserById(userId)).thenReturn(expectedUser);

        // Appeler la méthode à tester
        User actualUser = userService.getUserById(userId);

        // Vérifications
        assertEquals(expectedUser, actualUser, "L'utilisateur retourné doit correspondre à celui attendu");
        verify(userRepositoryMock).findUserById(userId); // Vérifie que findUserById a été appelé avec le bon argument
    }
}
