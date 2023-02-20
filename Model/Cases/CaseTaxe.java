package Model.Cases;

import Model.Joueur;

public class CaseTaxe extends Case {
    private int montant;

    public CaseTaxe(String nom, CaseCategorie categorie, int montant) {
        super(nom, categorie);
        this.montant = montant;
    }

    public String toString() {
        return String.format("C'est l\'heure des impots ! Vous payez %d à la banque", this.montant);
    }

    public void execute(Joueur joueur) {
        joueur.getPlateau().ajouterTaxe(this.montant);
    }
}
