package carcassonne;

import carcassonne.joueur.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarcassonneTest {

    Carcassonne objetDuTest ;

    @BeforeEach
    public void initTest() {
        objetDuTest = new Carcassonne();
    }

    @Test
    public void laPartieEstFinie() {
        assertFalse(objetDuTest.getFini());
        objetDuTest.seDérouler();
        assertFalse(objetDuTest.getFini());
        objetDuTest.addJoueur(new Joueur("Michel"));
        objetDuTest.seDérouler();
        assertTrue(objetDuTest.getFini());
    }

    @Test
    public void ajoutDeJoueur(){
        Joueur [] joueurs = new Joueur[10];
        for(int i = 0; i < joueurs.length; i++) {
            joueurs[i] = new Joueur("test "+i);
            boolean resultatAjout = objetDuTest.addJoueur(joueurs[i]);
            if (i < Carcassonne.NB_MAX_JOUEURS) assertTrue(resultatAjout, "ajout du "+i+"e joueur aurait du se faire");
            else assertFalse(resultatAjout, "ajout du "+i+"e joueur aurait du ne pas se faire");
        }
    }
}