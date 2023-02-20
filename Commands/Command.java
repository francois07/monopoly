package Commands;

import Controller.Plateau;
import Model.Joueur;
import View.GameInterface;

public abstract class Command {
  private CommandWord aCommandWord;
  private String aSecondWord;

  public Command() {
  }

  public void setCommandWord(CommandWord c) {
    this.aCommandWord = c;
  }

  public CommandWord getCommandWord() {
    return this.aCommandWord;
  }

  public String getSecondWord() {
    return this.aSecondWord;
  }

  public void setSecondWord(final String pS) {
    this.aSecondWord = pS;
  }

  public boolean hasSecondWord() {
    return this.getSecondWord() != null;
  }

  public boolean isUnknown() {
    return this.getCommandWord() == null;
  }

  static public GameInterface getJoueurInterface(Joueur joueur) {
    Plateau plateau = joueur.getPlateau();
    GameInterface gui = plateau.getGUI();

    return gui;
  }

  public abstract void execute(Joueur joueur);

}