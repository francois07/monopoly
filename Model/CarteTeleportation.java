package Model;

public class CarteTeleportation extends Carte {
    private int ncase;

    public CarteTeleportation(String nom, String description, boolean stockable, int ncase) {
        super(nom, description, stockable);
        this.ncase = ncase;
    }

    public void utiliser(Joueur joueur) {
        joueur.teleporter(this.ncase);
    }

}
