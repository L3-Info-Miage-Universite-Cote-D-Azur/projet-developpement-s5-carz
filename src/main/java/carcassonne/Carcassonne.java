package carcassonne;

import carcassonne.elements.Coordonnees;
import carcassonne.elements.Plateau;
import carcassonne.elements.Tuile;
import carcassonne.joueur.Joueur;

import java.util.ArrayList;

/**
 * Classe qui gère le déroulement du jeu
 * Point d'entrée pour l'exécution du projet
 */
public class Carcassonne {
    public static final int NB_MAX_JOUEURS = 5;

    boolean fini ;
    private ArrayList<Joueur> listeDeJoueurs;
    private Plateau plateau;

    public Carcassonne() {
        setFini(false);
        setPlateau(new Plateau());
        listeDeJoueurs = new ArrayList<>();
    }


    public void setFini(boolean fini) {
        this.fini = fini;
    }

    public boolean getFini() {
        return fini;
    }


    /**
     * exécution de la partie : faire les tours jusqu'à la fin du jeu
     */
    public void seDérouler() {
        if (listeDeJoueurs.size() > 0) {
            for(Joueur j : listeDeJoueurs){
                Tuile t = new Tuile();
                // @todo triche possible car le joueur peut modifier le plateau
                Coordonnees placement = j.placer(t, getPlateau());
                // @todo verification du placement
                getPlateau().ajouterTuile(placement, t);
            }
            setFini(true);
        }
    }

    /**
     * pour ajouter un joueur à la liste des joueurs, s'il y a insuffisamment de joueurs
     * @param joueur
     * @return true si l'ajout est effectif, faux s'il y a trop de joueur
     */
    public boolean addJoueur(Joueur joueur) {
        if (this.listeDeJoueurs.size() >= NB_MAX_JOUEURS) {
            return false;
        }
        else {
            this.listeDeJoueurs.add(joueur);
            return true;
        }
    }

    public static final void main(String [] args) {
        System.out.println("Carcassonne par le groupe CARZ");
        Carcassonne unePartie = new Carcassonne();
        // @todo rajouter des sorties textuelles
        unePartie.addJoueur(new Joueur("Michel"));
        unePartie.seDérouler();
    }


    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
