package Model;

import java.util.ArrayList;
import java.util.List;

import Controller.Plateau;

public class Joueur {
    private String nom;

    private Couleur couleur;

    private int lancerDoubles;

    private int pos;

    private int argent;

    private boolean prisonStatus;

    private List<Carte> cartes = new ArrayList<Carte>();

    private List<Propriete> proprietes = new ArrayList<Propriete>();

    private boolean enPrison;

    private Plateau plateau;

    public Joueur(Plateau plateau, final String nom) {
        this.plateau = plateau;
        this.nom = nom;
        this.argent = 20000;
        this.pos = 0;
        this.lancerDoubles = 0;
        this.prisonStatus = false;
    }

    public String toString() {
        // Retourne le nom du joueur sous le format "<Nom> (<Couleur>)"
        return this.nom;
    }

    public int getArgent() {
        return this.argent;
    }

    public int modifierArgent(final int somme) {
        this.argent = this.argent + somme;
        return (this.argent);
    }

    public void avancer(final int npos) {
        this.pos = this.pos + npos;
    }

    public void teleporter(final int numeroCase) {
        this.pos = numeroCase;
    }

    public void acheterPropriete(final Propriete propriete) {
        this.proprietes.add(propriete);
        this.modifierArgent(-propriete.getPrix()[propriete.getNiveau()]);
    }

    public int incrementLancerDoubles() {
        this.lancerDoubles = (lancerDoubles + 1) % 3;

        return this.lancerDoubles;
    }

    public void emprisonner() {
        this.teleporter(41);
        this.enPrison = true;
    }

    public void liberer() {
        this.enPrison = false;
    }

    public void setPrisonStatus(boolean ps) {
        this.enPrison = ps;
    }

    public int getPos() {
        return this.pos;
    }

    public Plateau getPlateau() {
        return this.plateau;
    }
}
