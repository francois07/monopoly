package Model;

public class CaseCarte extends Case {
  public CaseCarte(String nom, CaseCategorie categorie) {
    super(nom, categorie);
  }

  public String toString() {
    return "Vous piochez une carte";
  }

  public void execute(Joueur joueur) {
    Carte carte = joueur.getPlateau().piocher();

    if (!carte.isStockable()) {
      carte.utiliser(joueur);
    }
  }
}
