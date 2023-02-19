package Model;

public class Propriete {
    private String nom;

    private int[] prix;

    private int niveau;

    private int[] loyer;

    private Joueur proprietaire;

    public Propriete(final String nom, final int[] prix, final int[] loyer) {
        this.nom = nom;
        this.prix = prix;
        this.loyer = loyer;
        this.proprietaire = null;
        this.niveau = 0;
    }

    public String getNom() {
        return (this.nom);
    }

    public int getPrix() {
        return this.prix[this.niveau];
    }

    public int getPrixAmelioration() {
        return this.prix[this.niveau + 1];
    }

    public int getLoyer() {
        return this.loyer[this.niveau];
    }

    public Joueur getProprietaire() {
        return (this.proprietaire);
    }

    public int getNiveau() {
        return (this.niveau);
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public void setProprietaire(final Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void augmenterNiveau(final int niveau) {
        this.niveau += 1;
    }
}
