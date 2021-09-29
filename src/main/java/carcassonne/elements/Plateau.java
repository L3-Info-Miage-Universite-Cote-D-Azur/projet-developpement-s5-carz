package carcassonne.elements;

import java.util.HashMap;

/**
 *
 */
public class Plateau {

    private HashMap<Coordonnees, Tuile> tuiles = new HashMap<>();


    /**
     * tentative d'ajout d'une tuile à l'emplacement (x,y).
     * Si l'emplacement est vide, l'ajout est fait.
     * @param x abscisse
     * @param y ordonnée
     * @param t la tuile à placer
     * @return true si la place était libre et l'ajout est fait, sinon l'ajout ne se fait pas et retourne false
     */
    public boolean ajouterTuile(int x, int y, Tuile t) {
        return this.ajouterTuile(new Coordonnees(x, y), t);
    }

    public boolean ajouterTuile(Coordonnees coord, Tuile t) {
        boolean resultat = (tuiles.get(coord) == null);

        if (resultat) {
            // @todo vérifier si les tuiles sont compatibles
            tuiles.put(coord, t);
        }

        return resultat;
    }
}
