package TP2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Définition du comportement
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // ✅ Appel de la méthode à tester
        int resultat = calculatrice.additionner(2, 3);

        // ✅ Vérification du résultat
        assert(resultat == 5);

        // ✅ Vérifier que la méthode a été appelée avec les bons arguments
        verify(calculatrice).additionner(2, 3);

        // ✅ Vérifier qu'aucune autre méthode n’a été appelée
        verifyNoMoreInteractions(calculatrice);

        // ❌ Vérification de l’état : impossible ici car c’est un mock
        // Le champ `result` n’est pas modifié réellement → rien à vérifier
        // Si on utilisait une vraie instance, on pourrait faire :
        // assertEquals(5, calculatrice.getResult());
    }
}

