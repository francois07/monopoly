package Commands;

import Model.Joueur;
import View.GameInterface;
import View.Parser;

public class HelpCommand extends Command {
  public HelpCommand() {
  }

  public void execute(Joueur joueur) {
    GameInterface gui = Command.getJoueurInterface(joueur);
    Parser parser = joueur.getPlateau().getParser();

    gui.println("Les commandes disponibles sont les suivantes:\n" + parser.getCommandString());
  }
}
