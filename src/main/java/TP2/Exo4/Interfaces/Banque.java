package TP2.Exo4.Interfaces;

public interface Banque {
    void crediter(int somme);
    boolean est_solvable();
    void debiter(int somme);
}