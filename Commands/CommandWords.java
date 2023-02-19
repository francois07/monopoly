package Commands;

import java.util.HashMap;
import java.util.StringJoiner;

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
    StringJoiner res = new StringJoiner("\n- ", "- ", "");

    for (String i : this.aValidCommands.keySet())
      res.add(i);

    return res.toString();
  }
} // CommandWords