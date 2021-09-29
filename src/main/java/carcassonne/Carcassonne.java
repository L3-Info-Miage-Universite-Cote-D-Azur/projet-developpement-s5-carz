package carcassonne;

import carcassonne.elements.Coordonnees;
import carcassonne.elements.Plateau;
import carcassonne.elements.Tuile;
import carcassonne.joueur.Joueur;
import carcassonne.vue.AfficheMessage;

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
    private AfficheMessage vue;

    public Carcassonne(AfficheMessage vue) {
        setVue(vue);
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
        getVue().afficher("lancement du jeu");
        if (listeDeJoueurs.size() > 0) {
            getVue().afficher("le jeu commence, il y a "+listeDeJoueurs.size()+" joueur(s)");
            for(Joueur j : listeDeJoueurs){
                Tuile t = new Tuile();
                // @todo triche possible car le joueur peut modifier le plateau
                Coordonnees placement = j.choisirPlacementDeLaTuile(t, getPlateau());
                getVue().afficher(j+" place la tuile à "+placement);
                // @todo verification du placement
                getPlateau().ajouterTuile(placement, t);
            }
            setFini(true);
            // @todo déterminer le gagnant
            getVue().afficher("le jeu est fini, "+listeDeJoueurs.get(0)+" a gagné");
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
        AfficheMessage vue = new AfficheMessage();
        Carcassonne unePartie = new Carcassonne(vue);
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

    public void setVue(AfficheMessage vue) {
        this.vue = vue;
    }

    public AfficheMessage getVue() {
        return vue;
    }
}
