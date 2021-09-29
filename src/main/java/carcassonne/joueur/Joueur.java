package carcassonne.joueur;

import carcassonne.elements.Coordonnees;
import carcassonne.elements.Plateau;
import carcassonne.elements.Tuile;

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

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                '}';
    }

    public Coordonnees placer(Tuile t, Plateau plateau) {
        // @todo faire un choix de coordonnées -> IA !
        return new Coordonnees(0,0);
    }
}
