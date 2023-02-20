package Model.Cases;

import Model.Joueur;

public class CaseGoPrison extends Case {
  public CaseGoPrison(String nom, CaseCategorie categorie) {
    super(nom, categorie);
  }

  public String toString() {
    return "Vous allez en prison !";
  }

  public void execute(Joueur joueur) {
    joueur.emprisonner();
  }
}
