package View;

import java.util.StringTokenizer;

import Commands.CommandWords;
import Commands.Command;

public class Parser {

  private CommandWords CommandWords;

  public Parser() {
    this.CommandWords = new CommandWords();
  }

  public Command getCommand(final String pInputLine) {
    String vWord1;
    String vWord2;

    StringTokenizer tokenizer = new StringTokenizer(pInputLine);

    if (tokenizer.hasMoreTokens())
      vWord1 = tokenizer.nextToken();
    else
      vWord1 = null;

    if (tokenizer.hasMoreTokens())
      vWord2 = tokenizer.nextToken();
    else
      vWord2 = null;

    Command pC = (Command) CommandWords.getCommandFunction(vWord1);
    pC.setSecondWord(vWord2);

    return pC;
  }

  public String getCommandString() {
    return this.CommandWords.getCommandList();
  }

}