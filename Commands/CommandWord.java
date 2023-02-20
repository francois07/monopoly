package Commands;

/**
 * All the game's command words as constants.
 */

public enum CommandWord {
  HELP("help", new HelpCommand()),
  UNKNOWN("?", new UnknownCommand()),
  LANCER("lancer", new LancerCommand()),
  ACHETER("acheter", new AcheterCommand()),
  CARTES("cartes", new CartesCommand()),
  FINIR("finir", new FinirCommand()),
  UTILISER("utiliser", new UtiliserCommand());

  private String aCommandWord;
  private Command aCommand;

  CommandWord(final String pS, final Command pCommand) {
    this.aCommandWord = pS;
    this.aCommand = pCommand;
    this.aCommand.setCommandWord(this);
  }

  public String toString() {
    return this.aCommandWord;
  }

  public Command toCommand() {
    return this.aCommand;
  }
}
