package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

import Commands.Command;
import Commands.CommandWord;
import Model.Gare;
import Model.Joueur;
import Model.Propriete;
import Model.Cartes.Carte;
import Model.Cartes.CarteArgent;
import Model.Cartes.CarteCategorie;
import Model.Cartes.CarteMouvement;
import Model.Cartes.CarteProximite;
import Model.Cartes.CarteSortiePrison;
import Model.Cartes.CarteTeleportation;
import Model.Cases.Case;
import Model.Cases.CaseCarte;
import Model.Cases.CaseCategorie;
import Model.Cases.CaseDepart;
import Model.Cases.CaseGoPrison;
import Model.Cases.CaseParc;
import Model.Cases.CasePrison;
import Model.Cases.CasePropriete;
import Model.Cases.CaseTaxe;
import View.GameInterface;
import View.Parser;

public class Plateau {
    private int tour;
    private int taxes;
    private List<Case> cases;
    private List<Joueur> joueurs;
    private Joueur currentJoueur;
    private Stack<Carte> pioche;
    private GameInterface gameInterface;
    private Parser parser;
    private boolean inscription = true;

    public Plateau() {
        this.parser = new Parser();
        this.tour = 0;
        this.taxes = 0;
        this.joueurs = new ArrayList<Joueur>();
        this.cases = new ArrayList<Case>();
        this.pioche = new Stack<Carte>();
    }

    public void setGUI(final GameInterface gameInterface) {
        this.gameInterface = gameInterface;
        this.gameInterface
                .println(
                        "Veuillez inscrire au minimum 4 joueurs avec la commande inscrire <nom> [<noms>...]\nUne fois l'inscription terminee, utilisez la commande start");
    }

    public GameInterface getGUI() {
        return this.gameInterface;
    }

    public Parser getParser() {
        return this.parser;
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
                this.printStartOfTurnInfos();
            }
        } else {
            this.gameInterface.println("> " + cmd);
            Command fetchedCmd = this.parser.getCommand(cmd);

            if (!fetchedCmd.getCommandWord().toString().equals(CommandWord.LANCER.toString())) {
                if (currentJoueur.doitLancer()) {
                    this.gameInterface.println("Lance d\'abord les des !");
                    return;
                }
            }

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

        int total = r1 + r2;

        if (r1 == r2) {
            int d = joueur.incrementLancerDoubles();

            if (joueur.isEnPrison()) {
                this.gameInterface.println("Vous sortez de prison !");
                joueur.liberer();
            }

            if (d == 0) {
                this.gameInterface.println("3 doubles d\'affile... Vous etes suspect, allez en prison !");
                joueur.emprisonner();
            }
            this.gameInterface.println(String.format("Lancer double ! (%d & %d) On relance...\n", r1, r2));

            total += lancerDes(joueur);
        }

        return total;
    }

    public void printStartOfTurnInfos() {
        if (this.joueurs.size() != 1) {
            this.gameInterface.println(String.format(
                    "C\'est au tour de %s de lancer les des (avec la command lancer). Tu possede actuellement %d francs",
                    currentJoueur.toString(), currentJoueur.getArgent()));
        } else {
            this.gameInterface.println(String.format("%s a gagne la partie !", this.joueurs.get(0).toString()));
        }
    }

    public void printInfos() {
        String caseNom = this.cases.get(currentJoueur.getPos()).toString();
        this.gameInterface.println(caseNom);
    }

    public void initCases(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String lineSplit[] = line.split(",");

                String nom = lineSplit[0];
                CaseCategorie categorie = CaseCategorie.valueOf(lineSplit[1]);

                Case newCase;

                switch (categorie) {
                    case CASE_NORMALE:
                        String prix[] = Arrays.copyOfRange(lineSplit, 2, 7);
                        String loyer[] = Arrays.copyOfRange(lineSplit, 7, lineSplit.length - 1);

                        int prixInt[] = Arrays.stream(prix).mapToInt(Integer::parseInt).toArray();
                        int loyerInt[] = Arrays.stream(loyer).mapToInt(Integer::parseInt).toArray();

                        newCase = new CasePropriete(nom, categorie, new Propriete(nom, prixInt, loyerInt));
                        break;
                    case CASE_TAXE:
                        newCase = new CaseTaxe(nom, categorie, Integer.parseInt(lineSplit[2]));
                        break;
                    case CASE_CARTE:
                        newCase = new CaseCarte(nom, categorie);
                        break;
                    case CASE_GOPRISON:
                        newCase = new CaseGoPrison(nom, categorie);
                        break;
                    case CASE_DEPART:
                        newCase = new CaseDepart(nom, categorie);
                        break;
                    case CASE_PARC:
                        newCase = new CaseParc(nom, categorie);
                        break;
                    case CASE_PRISON:
                        newCase = new CasePrison(nom, categorie);
                        break;
                    case CASE_GARE:
                        int p = Integer.parseInt(lineSplit[2]);
                        loyer = Arrays.copyOfRange(lineSplit, 3, lineSplit.length - 1);
                        loyerInt = Arrays.stream(loyer).mapToInt(Integer::parseInt).toArray();

                        newCase = new CasePropriete(nom, categorie, new Gare(nom, p, loyerInt));
                        break;
                    default:
                        throw new Error("Categorie invalide");
                }

                this.cases.add(newCase);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initCartes(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String lineSplit[] = line.split(",");

                CarteCategorie categorie = CarteCategorie.valueOf(lineSplit[0]);

                Carte newCarte;

                switch (categorie) {
                    case CARTE_PROXIMITE:
                        newCarte = new CarteProximite(categorie.toString(), lineSplit[1],
                                Boolean.parseBoolean(lineSplit[2]));
                        break;
                    case CARTE_ARGENT:
                        newCarte = new CarteArgent(categorie.toString(), lineSplit[1],
                                Boolean.parseBoolean(lineSplit[2]), Integer.parseInt(lineSplit[3]));
                        break;
                    case CARTE_MOUVEMENT:
                        newCarte = new CarteMouvement(categorie.toString(), lineSplit[1],
                                Boolean.parseBoolean(lineSplit[2]), Integer.parseInt(lineSplit[3]));
                        break;
                    case CARTE_SORTIE_PRISON:
                        newCarte = new CarteSortiePrison(categorie.toString(), lineSplit[1],
                                Boolean.parseBoolean(lineSplit[2]));
                        break;
                    case CARTE_TELEPORTATION:
                        if (lineSplit.length == 4) {
                            newCarte = new CarteTeleportation(categorie.toString(), lineSplit[1],
                                    Boolean.parseBoolean(lineSplit[2]), Integer.parseInt(lineSplit[3]));
                        } else {
                            newCarte = new CarteTeleportation(categorie.toString(), lineSplit[1],
                                    Boolean.parseBoolean(lineSplit[2]), Integer.parseInt(lineSplit[3]),
                                    Boolean.parseBoolean(lineSplit[4]));
                        }
                        break;
                    default:
                        throw new Error("Categorie invalide");
                }

                this.pioche.push(newCarte);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Case> getCases() {
        return this.cases;
    }

    public void ajouterTaxe(int somme) {
        this.taxes += somme;
    }

    public int viderTaxe() {
        int res = this.taxes;
        this.taxes = 0;

        return res;
    }

    public Joueur nextJoueur() {
        this.currentJoueur.switchALancer();

        this.tour = (this.tour + 1) % this.joueurs.size();
        this.currentJoueur = this.joueurs.get(tour);

        return this.currentJoueur;
    }

    public boolean piocheEstVide() {
        return this.pioche.isEmpty();
    }

    public void applyLoss() {
        for (int i = 0; i < this.joueurs.size(); i++) {
            Joueur joueur = this.joueurs.get(i);

            if (joueur.getArgent() <= 0) {
                this.gameInterface.println(String.format("%s a fait faillite !", joueur.toString()));
                this.joueurs.remove(i);
            }
        }
    }
}
