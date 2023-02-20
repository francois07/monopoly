package Model.Cases;

import Model.Joueur;

public class CaseDepart extends Case {
  public CaseDepart(String nom, CaseCategorie categorie) {
    super(nom, categorie);
  }

  public String toString() {
    return "Vous atterissez sur la case depart !";
  }

  public void execute(Joueur joueur) {

  }
}
