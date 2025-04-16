package TP2.Exo4.Interfaces;

import TP2.Exo4.Interfaces.Exceptions.DebitImpossibleException;

public interface Joueur {
    int mise();
    void debiter(int somme) throws DebitImpossibleException;
    void crediter(int somme);
}
