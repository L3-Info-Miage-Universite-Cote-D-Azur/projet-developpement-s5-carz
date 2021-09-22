package carcassonne;

public class Carcassonne {

    boolean fini ;

    public Carcassonne() {
        setFini(true);
    }

    public static final void main(String [] args) {
        System.out.println("Carcassonne par le groupe CARZ");
    }

    public void setFini(boolean fini) {
        this.fini = fini;
    }

    public boolean getFini() {
        return fini;
    }
}
