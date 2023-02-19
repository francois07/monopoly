package Commands;

/**
 * All the game's command words as constants.
 */

public enum CommandWord {
  HELP("help", new HelpCommand()),
  UNKNOWN("?", new UnknownCommand());
  ;

  private String aCommandWord;
  private Command aCommand;

  CommandWord(final String pS, final Command pCommand) {
    this.aCommandWord = pS;
    this.aCommand = pCommand;
  }

  public String toString() {
    return this.aCommandWord;
  }

  public Command toCommand() {
    return this.aCommand;
  }
}
