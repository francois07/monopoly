package Model.Cartes;

import Model.Joueur;

public class CarteMouvement extends Carte {
    private int nbCases;

    public CarteMouvement(String nom, String description, boolean stockable, int nbCases) {
        super(nom, description, stockable);
        this.nbCases = nbCases;
    }

    public void utiliser(Joueur joueur) {
        joueur.getPlateau().getGUI().println(String.format("Vous avancez de %d cases", this.nbCases));
        joueur.avancer(this.nbCases);
    }

}
