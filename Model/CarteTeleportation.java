package Model;

public class CarteTeleportation extends Carte {
    private int ncase;
    private boolean prisonSansArgent;

    public CarteTeleportation(String nom, String description, boolean stockable, int ncase) {
        super(nom, description, stockable);
        this.ncase = ncase;
        this.prisonSansArgent=false;
    }

    public CarteTeleportation(String nom, String description, boolean stockable, int ncase, boolean psa) {
        super(nom, description, stockable);
        this.ncase = ncase;
        this.prisonSansArgent=psa;
    }

    public void utiliser(Joueur joueur) {
        if (!prisonSansArgent && joueur.getPos()>this.ncase) joueur.modifierArgent(200);
        if (prisonSansArgent) joueur.setPrisonStatus(true);
        joueur.teleporter(this.ncase);
    }

}
