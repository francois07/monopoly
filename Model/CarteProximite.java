package Model;

public class CarteProximite extends Carte {
    private int nbCases;

    public CarteProximite(String n, String d, boolean st) {
        super(n, d, st);
    }

    public void utiliser(Joueur joueur) { // aller a la gare la plus proche
        joueur.avancer(this.nbCases);
    }

}