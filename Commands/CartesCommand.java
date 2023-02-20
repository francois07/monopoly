package Commands;

import java.util.List;
import java.util.StringJoiner;

import Model.Joueur;
import Model.Cartes.Carte;
import View.GameInterface;

public class CartesCommand extends Command {
  public CartesCommand() {
  }

  public void execute(Joueur joueur) {
    GameInterface gui = Command.getJoueurInterface(joueur);
    List<Carte> joueurCartes = joueur.getCartes();
    StringJoiner cartes = new StringJoiner("\n- ", "- ", "");

    if (joueurCartes.size() > 0) {
      for (int i = 0; i < joueurCartes.size(); i++) {
        Carte carte = joueurCartes.get(i);
        cartes.add(String.format("(%d) %s", i, carte.getNom()));
      }

      gui.println("Tu possedes les cartes suivantes :\n" + cartes.toString());
    } else {
      gui.println("Tu ne possedes aucune carte !");

    }
  }
}
