package TP2.Exo4;

import TP2.Exo4.Interfaces.Banque;
import TP2.Exo4.Interfaces.De;
import TP2.Exo4.Interfaces.Exceptions.DebitImpossibleException;
import TP2.Exo4.Interfaces.Exceptions.JeuFermeException;
import TP2.Exo4.Interfaces.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JeuTest {

    private Banque banque;
    private Joueur joueur;
    private De de1, de2;
    private Jeu jeu;

    @BeforeEach
    void setup() {
        banque = mock(Banque.class);
        joueur = mock(Joueur.class);
        de1 = mock(De.class);
        de2 = mock(De.class);
        jeu = new Jeu(banque);
    }

    // ✅ 1. Jeu fermé → exception
    @Test
    void testJeuFerme_ThrowsException() {
        jeu.fermer();
        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueur, de1, de2));
    }

    // ✅ 2. Joueur insolvable → aucun lancer de dé
    @Test
    void testJoueurInsolvable_NeLancePasLesDes() throws Exception {
        when(joueur.mise()).thenReturn(50);
        doThrow(new DebitImpossibleException("Fonds insuffisants"))
                .when(joueur).debiter(50);

        jeu.jouer(joueur, de1, de2);

        verify(joueur).mise();
        verify(joueur).debiter(50);
        verifyNoInteractions(de1, de2);
        verifyNoInteractions(banque);
    }

    // ✅ 3. Joueur perd (somme ≠ 7)
    @Test
    void testJoueurPerd() throws Exception {
        when(joueur.mise()).thenReturn(10);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(2); // somme = 5
        when(banque.est_solvable()).thenReturn(true);

        jeu.jouer(joueur, de1, de2);

        verify(joueur).debiter(10);
        verify(banque).crediter(10);
        verify(banque, never()).debiter(anyInt());
        verify(joueur, never()).crediter(anyInt());
        assertTrue(jeu.estOuvert());
    }

    // ✅ 4. Joueur gagne (somme == 7)
    @Test
    void testJoueurGagne() throws Exception {
        when(joueur.mise()).thenReturn(20);
        when(de1.lancer()).thenReturn(4);
        when(de2.lancer()).thenReturn(3); // somme = 7
        when(banque.est_solvable()).thenReturn(true);

        jeu.jouer(joueur, de1, de2);

        verify(banque).debiter(40); // 2 * mise
        verify(joueur).crediter(40);
        assertTrue(jeu.estOuvert());
    }

    // ✅ 5. Joueur gagne mais la banque devient insolvable
    @Test
    void testBanqueDevientInsolvableApresGain() throws Exception {
        when(joueur.mise()).thenReturn(10);
        when(de1.lancer()).thenReturn(2);
        when(de2.lancer()).thenReturn(5); // somme = 7
        when(banque.est_solvable()).thenReturn(false); // jeu doit se fermer

        jeu.jouer(joueur, de1, de2);

        assertFalse(jeu.estOuvert());
    }

    // ✅ 6. Test semi-intégré avec vraie banque
    @Test
    void testGagneEtBanqueInsolvableAvecImplementationReelle() throws Exception {
        BanqueReelle banqueReelle = new BanqueReelle(30, 20); // fond initial 30, min 20
        Jeu jeuReel = new Jeu(banqueReelle);

        Joueur joueurFake = mock(Joueur.class);
        De deFake1 = mock(De.class);
        De deFake2 = mock(De.class);

        when(joueurFake.mise()).thenReturn(10);
        when(deFake1.lancer()).thenReturn(3);
        when(deFake2.lancer()).thenReturn(4); // somme = 7

        jeuReel.jouer(joueurFake, deFake1, deFake2);

        // gain = 20, la banque passe de 30 - 20 = 10 < 20 → plus solvable
        assertFalse(jeuReel.estOuvert());
    }





}


