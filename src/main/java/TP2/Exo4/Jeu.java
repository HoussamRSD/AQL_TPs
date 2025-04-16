package TP2.Exo4;

import TP2.Exo4.Interfaces.Banque;
import TP2.Exo4.Interfaces.De;
import TP2.Exo4.Interfaces.Exceptions.DebitImpossibleException;
import TP2.Exo4.Interfaces.Exceptions.JeuFermeException;
import TP2.Exo4.Interfaces.Joueur;

public class Jeu {
    private boolean ouvert = true;
    private final Banque banque;

    public Jeu(Banque banque) {
        this.banque = banque;
    }

    public void fermer() {
        ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) throw new JeuFermeException("Le jeu est fermé");

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
        } catch (DebitImpossibleException e) {
            return; // joueur insolvable : on ne continue pas
        }

        banque.crediter(mise);

        int somme = de1.lancer() + de2.lancer();
        if (somme == 7) {
            int gain = 2 * mise;
            joueur.crediter(gain);
            banque.debiter(gain);
            if (!banque.est_solvable()) fermer();
        }
    }
}