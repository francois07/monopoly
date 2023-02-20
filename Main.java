import Controller.Plateau;
import View.GameInterface;
import Model.Carte;
import Model.Joueur;

public class Main {
  public static void main(String args[]) {
    Plateau plateau = new Plateau();

    plateau.initCases("cases.csv");
    plateau.initCartes("cartes.csv");

    GameInterface gameinterface = new GameInterface(plateau);
    plateau.setGUI(gameinterface);

    while(true){
      Joueur playerPlaying = plateau.nextJoueur();
      playerPlaying.avancer(plateau.lancerDes(playerPlaying));
      switch(plateau.getCases().get(playerPlaying.getPos()).getCategorie()){
        case CASE_CHANCE:
          Carte carteChance = plateau.piocher();
          break;
        case CASE_COMMUNAUTE:
          Carte carteCom = plateau.piocher();
          break;
        case CASE_COMPAGNIE:
          
          break;
        case CASE_DEPART:
          break;
        case CASE_GOPRISON:
          break;
        case CASE_NORMALE:
          break;
        case CASE_PARC:
          break;
        case CASE_PRISON:
          break;
        case CASE_TAXE:
          break;
        default:
          break;

      }
    }
  }
}
