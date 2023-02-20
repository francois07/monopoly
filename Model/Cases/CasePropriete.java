package Model.Cases;

import java.util.Objects;

import Model.Joueur;
import Model.Propriete;
import View.GameInterface;

public class CasePropriete extends Case {
    private Propriete propriete;

    public CasePropriete(String nom, CaseCategorie categorie, Propriete propriete) {
        super(nom, categorie);
        this.propriete = propriete;
    }

    public String toString() {
        String res = String.format("Vous etes arrive sur la propriete : %s", propriete.getNom());
        return (res);
    }

    public Propriete getPropriete() {
        return this.propriete;
    }

    public void execute(Joueur joueur) {
        Joueur proprietaire = this.propriete.getProprietaire();
        GameInterface gui = joueur.getPlateau().getGUI();

        if (!Objects.isNull(proprietaire)) {
            if (!proprietaire.equals(joueur)) {
                int prix = this.propriete.getLoyer();

                gui.println(String.format("Tu visites la propriete de %s et payes par consequent un loyer de %d francs",
                        proprietaire.toString(),
                        prix));

                joueur.donnerArgent(proprietaire, prix);
            } else {
                gui.println(String.format(
                        "Cette propriete t\'appartient et elle est de niveau %d. Utilise la commande ameliorer pour l\'ameliorer au prix de %d francs",
                        this.propriete.getNiveau(),
                        this.propriete.getPrixAmelioration()));
            }
        } else {
            gui.println(String.format(
                    "Cette propriete n\'appartient a personne, elle coute %d francs. Utilise la commande acheter pour l\'acheter",
                    this.propriete.getPrix()));
        }
    }
}
