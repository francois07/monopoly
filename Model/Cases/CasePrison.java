package Model.Cases;

import Model.Joueur;

public class CasePrison extends Case {
  public CasePrison(String nom, CaseCategorie categorie) {
    super(nom, categorie);
  }

  public String toString() {
    return "Vous etes dans la prison";
  }

  public void execute(Joueur joueur) {

  }
}
