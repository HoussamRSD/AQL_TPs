package TP2.Exo3;


public class Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private int id; // ID généré par l'API

    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    // Setter pour l'ID
    public void setId(int id) {
        this.id = id;
    }

    // Pour les vérifications dans les tests
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur)) return false;
        Utilisateur u = (Utilisateur) o;
        return nom.equals(u.nom) && prenom.equals(u.prenom) && email.equals(u.email);
    }

    @Override
    public int hashCode() {
        return nom.hashCode() + prenom.hashCode() + email.hashCode();
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " <" + email + "> (id=" + id + ")";
    }
}
