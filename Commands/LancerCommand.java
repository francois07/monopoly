package Commands;

import Controller.Plateau;
import Model.Joueur;
import View.GameInterface;

public class LancerCommand extends Command {
  public LancerCommand() {
  }

  public void execute(Joueur joueur) {
    Plateau plateau = joueur.getPlateau();
    GameInterface gui = Command.getJoueurInterface(joueur);
    int res = plateau.lancerDes(joueur);

    gui.println(String.format("%s avance de %d cases\n", joueur.toString(), res));
  }
}
