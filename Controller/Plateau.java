package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.StringJoiner;

import Commands.Command;
import Model.Carte;
import Model.Case;
import Model.Joueur;
import View.GameInterface;
import View.Parser;

public class Plateau {
    private int tour;

    private int taxes;

    private Case cases[];

    private List<Joueur> joueurs;

    private Joueur currentJoueur;

    private Stack<Carte> pioche;

    private GameInterface gameInterface;

    private Parser parser;

    private boolean inscription = true;

    public Plateau() {
        this.parser = new Parser();
        this.tour = 1;
        this.taxes = 0;
        this.joueurs = new ArrayList<Joueur>();
    }

    public void setGUI(final GameInterface gameInterface) {
        this.gameInterface = gameInterface;
        this.gameInterface
                .println(
                        "Veuillez inscrire au minimum 4 joueurs avec la commande inscrire <nom> [<noms>...]\nUne fois l'inscription terminée, utilisez la commande start");
    }

    public GameInterface getGUI() {
        return this.gameInterface;
    }

    public void parseCommand(final String cmd) {
        if (inscription) {
            if (cmd.startsWith("inscrire")) {
                String split[] = cmd.split(" ");

                for (int i = 1; i < split.length; i++) {
                    Joueur newJoueur = new Joueur(this, split[i]);
                    this.joueurs.add(newJoueur);
                }

                this.gameInterface.println("Joueurs actuels: " + this.joueursString());
            } else if (this.joueurs.size() < 4) {
                this.gameInterface
                        .println("Veuillez inscrire au minimum 4 joueurs avec la commande inscrire <nom> [<noms>...]");
            } else if (cmd.startsWith("start")) {
                this.inscription = false;
                this.currentJoueur = joueurs.get(0);
                this.gameInterface.println("La partie peut commencer !");
            }
        } else {
            this.gameInterface.println("> " + cmd);
            Command fetchedCmd = this.parser.getCommand(cmd);

            fetchedCmd.execute(this.currentJoueur);
        }

    }

    public Carte piocher() {
        return this.pioche.pop();
    }

    public String joueursString() {
        StringJoiner joiner = new StringJoiner(" ");

        for (Joueur j : this.joueurs) {
            joiner.add(j.toString());
        }

        return joiner.toString();
    }

    public int lancerDes(Joueur joueur) {
        Random r = new Random();

        int r1 = r.nextInt(5) + 1;
        int r2 = r.nextInt(5) + 1;

        joueur.avancer(r1 + r2);

        if (r1 == r2) {
            int d = joueur.incrementLancerDoubles();

            if (d == 0) {
                joueur.teleporter(41);
            }

            lancerDes(joueur);
        }

        return r1 + r2;
    }
}
