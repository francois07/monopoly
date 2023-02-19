package Commands;

import java.util.List;
import java.util.Objects;

import Controller.Plateau;
import Model.Case;
import Model.CaseCategorie;
import Model.CasePropriete;
import Model.Joueur;
import Model.Propriete;
import View.GameInterface;

public class AcheterCommand extends Command {
  public AcheterCommand() {
  }

  public void execute(Joueur joueur) {
    Plateau plateau = joueur.getPlateau();
    Case caseAcheter = plateau.getCases().get(joueur.getPos());
    GameInterface gui = Command.getJoueurInterface(joueur);

    if (caseAcheter.getCategorie() == CaseCategorie.CASE_NORMALE) {
      Propriete propriete = ((CasePropriete) caseAcheter).getPropriete();

      if (Objects.isNull(propriete.getProprietaire())) {
        if (joueur.getArgent() > propriete.getPrix()) {
          joueur.acheterPropriete(propriete);
          gui.println(
              String.format("Tu as achete cette propriete, ton solde est maintenant de %d francs", joueur.getArgent()));
        } else {
          gui.println("Tu n\'as pas assez d\'argent !");
        }
      } else {
        gui.println("Cette propriete appartient deja a un joueur !");
      }
    } else {
      gui.println("Cette case ne contient pas de propriete achetable !");
    }
  }
}
