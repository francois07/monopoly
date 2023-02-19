package Model;

public abstract class Carte {
    private String nom;

    private String description;

    private boolean stockable;

    public abstract void utiliser(final Joueur joueur);

    public Carte(String nom, String description, boolean stockable) {
        this.nom = nom;
        this.description = description;
        this.stockable = stockable;
    }

    public String getNom() {
        return (this.nom);
    }

    public String getDescription() {
        return (this.description);
    }

    public boolean isStockable() {
        return (this.stockable);
    }
}
