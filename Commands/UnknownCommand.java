package Commands;

import Model.Joueur;
import View.GameInterface;

public class UnknownCommand extends Command {
  public UnknownCommand() {
  }

  public void execute(Joueur joueur) {
    GameInterface gui = Command.getJoueurInterface(joueur);

    gui.println("Je n\'ai pas compris!");
  }
}
