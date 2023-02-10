import Controller.Game;
import View.GameInterface;

public class Main {
  public static void main(String args[]) {
    Game game = new Game();
    GameInterface gameinterface = new GameInterface(game);
    game.setGUI(gameinterface);
  }
}
