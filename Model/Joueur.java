package Model;

import java.util.ArrayList;
import java.util.List;

import Controller.Plateau;
import Model.Cartes.Carte;
import Model.Cases.Case;

public class Joueur {
    private String nom;
    private int lancerDoubles;
    private int pos;
    private int argent;
    private List<Carte> cartes = new ArrayList<Carte>();
    private List<Propriete> proprietes = new ArrayList<Propriete>();
    private boolean enPrison;
    private Plateau plateau;

    private boolean aLance;

    public Joueur(Plateau plateau, final String nom) {
        this.plateau = plateau;
        this.nom = nom;
        this.argent = 150000;
        this.pos = 0;
        this.lancerDoubles = 0;
    }

    public String toString() {
        return this.nom;
    }

    public int getArgent() {
        return this.argent;
    }

    public int ajouterArgent(final int somme) {
        this.argent = this.argent + somme;
        return (this.argent);
    }

    public void avancer(final int npos) {
        if (this.enPrison)
            return;

        List<Case> cases = this.plateau.getCases();
        int n = cases.size();
        this.pos = this.pos + npos;

        if (this.pos > n) {
            this.plateau.getGUI()
                    .println("Vous avez fait un tour complet! Gagnez 20000 francs. Vous possedez maintenant "
                            + this.argent + " francs");
            this.pos = this.pos % n;
            this.ajouterArgent(20000);
        }
    }

    public void teleporter(final int numeroCase) {
        this.pos = numeroCase;
    }

    public void acheterPropriete(final Propriete propriete) {
        this.proprietes.add(propriete);
        propriete.setProprietaire(this);
        this.ajouterArgent(-propriete.getPrix());
    }

    public int incrementLancerDoubles() {
        this.lancerDoubles = (lancerDoubles + 1) % 3;

        return this.lancerDoubles;
    }

    public void emprisonner() {
        this.teleporter(10);
        this.enPrison = true;
    }

    public void liberer() {
        this.enPrison = false;
    }

    public int getPos() {
        return this.pos;
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

    public void donnerArgent(Joueur joueur, int somme) {
        this.argent -= somme;
        joueur.argent += somme;
    }

    public boolean equals(Joueur joueur) {
        return this.nom.equals(joueur.nom);
    }

    public boolean doitLancer() {
        return !aLance;
    }

    public void switchALancer() {
        this.aLance = !this.aLance;
    }

    public void stockerCarte(Carte carte) {
        this.cartes.add(carte);
    }

    public List<Propriete> getProprietes() {
        return this.proprietes;
    }

    public boolean isEnPrison() {
        return this.enPrison;
    }

    public List<Carte> getCartes() {
        return this.cartes;
    }

    public Case getCurrentCase() {
        return this.plateau.getCases().get(this.pos);
    }
}
