import Controller.Plateau;
import View.GameInterface;

public class Main {
  public static void main(String args[]) {
    Plateau plateau = new Plateau();
    GameInterface gameinterface = new GameInterface(plateau);
    plateau.setGUI(gameinterface);
  }
}
