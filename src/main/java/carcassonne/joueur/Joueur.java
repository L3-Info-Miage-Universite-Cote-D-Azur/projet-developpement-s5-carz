package carcassonne.joueur;

public class Joueur {
    private String nom;

    public Joueur(String nom) {
        setNom(nom);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
