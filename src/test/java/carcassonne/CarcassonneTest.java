package carcassonne;

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
        assertTrue(objetDuTest.getFini());
    }

}