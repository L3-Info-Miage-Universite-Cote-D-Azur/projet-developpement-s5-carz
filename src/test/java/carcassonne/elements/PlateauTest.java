package carcassonne.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {
    Plateau plateauTesté ;

    @BeforeEach
    void setUp() {
        plateauTesté = new Plateau();
    }

    @Test
    void testAjouterTuileXY() {
        int x = 0, y = 0;
        Tuile t = new Tuile();

        assertTrue(plateauTesté.ajouterTuile(x, y, t));
        Tuile t2 = new Tuile();
        assertFalse(plateauTesté.ajouterTuile(x, y, t2));
        assertTrue(plateauTesté.ajouterTuile(x+1, y, t2));
    }

    @Test
    void testAjouterTuileCoord() {
        Coordonnees coord = new Coordonnees(0,0);
        Tuile t = new Tuile();

        assertFalse(plateauTesté.ajouterTuile(null, t));

        assertTrue(plateauTesté.ajouterTuile(coord, t));
        Tuile t2 = new Tuile();
        assertFalse(plateauTesté.ajouterTuile(coord, t2));
        Coordonnees coord2 = new Coordonnees(1,0);

        assertTrue(plateauTesté.ajouterTuile(coord2, t2));
    }
}