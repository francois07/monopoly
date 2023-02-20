package Model.Cases;

import Model.Joueur;

public class CaseParc extends Case {

  public CaseParc(String nom, CaseCategorie categorie) {
    super(nom, categorie);
  }

  public String toString() {
    return String.format("Vous recoltez l\'ensemble des taxes deposees !");
  }

  public void execute(Joueur joueur) {
    joueur.ajouterArgent(joueur.getPlateau().viderTaxe());
  }
}
