package Model.Cartes;

import Model.Joueur;

public class CarteSortiePrison extends Carte {

    public CarteSortiePrison(String nom, String description, boolean stockable) {
        super(nom, description, stockable);
    }

    public void utiliser(Joueur joueur) {
        joueur.getPlateau().getGUI().println("Vous sortez de prison !");
        joueur.liberer();
    }

}
