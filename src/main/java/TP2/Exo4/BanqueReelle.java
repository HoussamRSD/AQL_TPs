package TP2.Exo4;

import TP2.Exo4.Interfaces.Banque;

public class BanqueReelle implements Banque {
    private int fond;
    private final int fondMinimum;

    public BanqueReelle(int fondInitial, int fondMinimum) {
        this.fond = fondInitial;
        this.fondMinimum = fondMinimum;
    }

    @Override
    public void crediter(int somme) {
        fond += somme;
    }

    @Override
    public void debiter(int somme) {
        fond -= somme;
    }

    @Override
    public boolean est_solvable() {
        return fond > fondMinimum;
    }

}
