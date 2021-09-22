package carcassonne;

import carcassonne.joueur.Joueur;

import java.util.ArrayList;

public class Carcassonne {

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



    public void seDérouler() {
        if (listeDeJoueurs.size() > 0) {
            setFini(true);
        }
    }

    public void addJoueur(Joueur joueur) {
        this.listeDeJoueurs.add(joueur);
    }

    public static final void main(String [] args) {
        System.out.println("Carcassonne par le groupe CARZ");
        Carcassonne unePartie = new Carcassonne();
        // @todo rajouter des sorties textuelles
        unePartie.addJoueur(new Joueur("Michel"));
        unePartie.seDérouler();
    }


}
