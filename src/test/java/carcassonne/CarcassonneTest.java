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

}