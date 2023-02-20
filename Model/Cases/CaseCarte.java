package Model.Cases;

import Model.Joueur;
import Model.Cartes.Carte;

public class CaseCarte extends Case {
  public CaseCarte(String nom, CaseCategorie categorie) {
    super(nom, categorie);
  }

  public String toString() {
    return "Vous arrivez sur une case speciale et piochez une carte";
  }

  public void execute(Joueur joueur) {
    if (!joueur.getPlateau().piocheEstVide()) {
      Carte carte = joueur.getPlateau().piocher();

      if (!carte.isStockable()) {
        joueur.getPlateau().getGUI().println("La carte n\'est pas stockable, vous l\'utilisez instantanement");
        carte.utiliser(joueur);
      } else {
        joueur.stockerCarte(carte);
      }
    } else {
      joueur.getPlateau().getGUI().println("Vouss arrivez sur une case carte mais la pioche est vide !");
    }
  }
}
