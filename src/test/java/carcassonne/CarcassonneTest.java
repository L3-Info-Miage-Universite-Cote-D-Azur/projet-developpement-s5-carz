package carcassonne;

import carcassonne.elements.Coordonnees;
import carcassonne.joueur.Joueur;
import carcassonne.vue.AfficheMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarcassonneTest {

    Carcassonne objetDuTest ;

    @Mock
    Joueur michel;

    @Mock
    AfficheMessage vue;

    @BeforeEach
    public void initTest() {
        objetDuTest = new Carcassonne(vue);
    }

    @Test
    public void laPartieEstFinie() {
        assertFalse(objetDuTest.getFini());
        objetDuTest.seDérouler();
        assertFalse(objetDuTest.getFini());

        // when(michel.placer(any(), any()))).thenReturn(new Coordonnees(1,1));
        when(michel.choisirPlacementDeLaTuile(any(), eq((objetDuTest.getPlateau())))).thenReturn(new Coordonnees(1,1));
        objetDuTest.addJoueur(michel);

        objetDuTest.seDérouler();
        assertTrue(objetDuTest.getFini());
        assertEquals(1, objetDuTest.getPlateau().getNombreTuilePlacées(), "une tuile a été placé");
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