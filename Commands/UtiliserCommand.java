package Commands;

import java.util.List;

import Model.Joueur;
import Model.Cartes.Carte;
import View.GameInterface;

public class UtiliserCommand extends Command {
  public UtiliserCommand() {
  }

  public void execute(Joueur joueur) {
    GameInterface gui = Command.getJoueurInterface(joueur);
    List<Carte> joueurCartes = joueur.getCartes();

    String num = this.getSecondWord();
    if (num.isEmpty()) {
      gui.println("Veuillez specifier un numero de carte");
    } else {
      try {
        int n = Integer.parseInt(num);

        if (n > joueurCartes.size()) {
          gui.println("Veuillez specifier un numero de carte valide");
        } else {
          Carte carte = joueurCartes.get(n);
          carte.utiliser(joueur);
          joueurCartes.remove(n);
        }
      } catch (NumberFormatException e) {
        gui.println("Veuillez specifier un numero de carte valide");
      }
    }
  }
}
