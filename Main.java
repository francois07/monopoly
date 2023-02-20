import Controller.Plateau;
import View.GameInterface;

public class Main {
  public static void main(String args[]) {
    Plateau plateau = new Plateau();

    plateau.initCases("cases.csv");
    plateau.initCartes("cartes.csv");

    GameInterface gameinterface = new GameInterface(plateau);
    plateau.setGUI(gameinterface);
  }
}
