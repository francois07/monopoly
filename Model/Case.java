package Model;

public abstract class Case {
    private String nom;

    private CaseCategorie categorie;

    public abstract String toString();

    public abstract void execute(Joueur joueur);

    public Case(String nom, CaseCategorie categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }

    public CaseCategorie getCategorie() {
        return this.categorie;
    }
}
