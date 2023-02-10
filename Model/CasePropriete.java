package Model;

public class CasePropriete extends Case {
    private Propriete propriete;

    public CasePropriete(String nom, CaseCategorie categorie, Propriete propriete) {
        super(nom, categorie);
        this.propriete = propriete;
    }

    public String toString() {
        String res = String.format("Vous êtes arrivé sur la propriété : %s", propriete.getNom());
        return (res);
    }

}
