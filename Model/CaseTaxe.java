package Model;

public class CaseTaxe extends Case {
    private int montant;

    public CaseTaxe(String nom, CaseCategorie categorie, int montant) {
        super(nom, categorie);
        this.montant = montant;
    }

    public String toString() {
        return String.format("C'est l'heure des impots ! Vous payez %d à la banque", this.montant);
    }
}
