package Commands;

import java.util.HashMap;

/**
 * The CommandWords class.
 */
public class CommandWords {
  private HashMap<String, CommandWord> aValidCommands;

  /**
   * The class' constructor.
   */
  public CommandWords() {
    this.aValidCommands = new HashMap<String, CommandWord>();
    for (CommandWord vC : CommandWord.values()) {
      if (vC != CommandWord.UNKNOWN)
        this.aValidCommands.put(vC.toString(), vC);
    }
  }

  /**
   * @return The command word associated to a command.
   */
  public CommandWord getCommandWord(final String pS) {
    CommandWord vC = this.aValidCommands.get(pS.toLowerCase());
    if (vC != null)
      return vC;
    else
      return CommandWord.UNKNOWN;
  }

  public Command getCommandFunction(final String pS) {
    return this.getCommandWord(pS).toCommand();
  }

  /**
   * Check whether a given String is a valid command word or not.
   */
  public boolean isCommand(final String pS) {
    return this.aValidCommands.containsKey(pS.toLowerCase());
  } // isCommand()

  /**
   * @return All the command words as a String.
   */
  public String getCommandList() {
    String vS = "";
    for (String i : this.aValidCommands.keySet())
      vS += i + " ";
    return vS;
  }
} // CommandWords