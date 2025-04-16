package TP2.Exo2;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String email;

    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getters (au besoin, pour des tests d'état ou de logs)
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    // equals() et hashCode() utiles pour les vérifications dans les mocks
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Utilisateur)) return false;
        Utilisateur other = (Utilisateur) obj;
        return nom.equals(other.nom) &&
                prenom.equals(other.prenom) &&
                email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return nom.hashCode() + prenom.hashCode() + email.hashCode();
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " <" + email + ">";
    }
}

