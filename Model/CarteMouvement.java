package Model;

public class CarteMouvement extends Carte {
    private int nbCases;

    public CarteMouvement(String n, String d, boolean st, int nc) {
        super(n, d, st);
        this.nbCases = nc;
    }

    public void utiliser(Joueur joueur) {
        joueur.avancer(this.nbCases);
    }

}
