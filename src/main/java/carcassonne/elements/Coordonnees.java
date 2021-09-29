package carcassonne.elements;

import java.util.Objects;

public class Coordonnees {

    private int x;
    private int y;

    public Coordonnees() {
        this(0,0);
    }

    public Coordonnees(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        return "Coordonnees{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean equals(Object o){
        if (o instanceof Coordonnees) {
            Coordonnees comparaison = (Coordonnees) o;
            return (comparaison.getX() == getX()) && (comparaison.getY() == getY());
        }
        else return false;
    }

    @Override
    public int hashCode() {
        // return Objects.hash(x, y);
        return toString().hashCode();
    }
}
