package carcassonne;

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

    public Carcassonne() {
        setFini(false);
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


}
