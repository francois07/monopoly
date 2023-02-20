package Commands;

import java.util.HashMap;
import java.util.StringJoiner;

public class CommandWords {
  private HashMap<String, CommandWord> aValidCommands;

  public CommandWords() {
    this.aValidCommands = new HashMap<String, CommandWord>();
    for (CommandWord vC : CommandWord.values()) {
      if (vC != CommandWord.UNKNOWN)
        this.aValidCommands.put(vC.toString(), vC);
    }
  }

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

  public boolean isCommand(final String pS) {
    return this.aValidCommands.containsKey(pS.toLowerCase());
  }

  public String getCommandList() {
    StringJoiner res = new StringJoiner("\n- ", "- ", "");

    for (String i : this.aValidCommands.keySet())
      res.add(i);

    return res.toString();
  }
}