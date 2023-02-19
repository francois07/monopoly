package Model;

public class CarteProximite extends Carte {
    private int nbCases;

    public CarteProximite(String nom, String description, boolean stockable) {
        super(nom, description, stockable);
    }

    public void utiliser(Joueur joueur) { // aller a la gare la plus proche
        joueur.avancer(((int) (joueur.getPos() / 10) * 10) + 5);
    }

}