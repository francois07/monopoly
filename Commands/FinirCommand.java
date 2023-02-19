package Commands;

import Controller.Plateau;
import Model.Joueur;
import View.GameInterface;

public class FinirCommand extends Command {
  public FinirCommand() {
  }

  public void execute(Joueur joueur) {
    Plateau plateau = joueur.getPlateau();
    GameInterface gui = Command.getJoueurInterface(joueur);

    gui.println(String.format("%s termine son tour", joueur.toString()));

    plateau.nextJoueur();

    plateau.printStartOfTurnInfos();
  }
}
