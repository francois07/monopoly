package Model;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;

    private Couleur couleur;

    private int lancerDoubles;

    private int cases;

    private int argent;

    private List<Carte> cartes = new ArrayList<Carte>();

    private List<Propriete> proprietes = new ArrayList<Propriete>();

    private boolean enPrison;

    public Joueur(final String nom, final Couleur couleur, final int argent) {
        this.nom = nom;
        this.couleur = couleur;
        this.argent = argent;
        this.cases = 0;
        this.lancerDoubles = 0;
    }

    public String toString() {
        // Retourne le nom du joueur sous le format "<Nom> (<Couleur>)"
        String res = String.format("%s (%s)", this.nom, this.couleur);
        return (res);
    }

    public int modifierArgent(final int somme) {
        this.argent = this.argent + somme;
        return (this.argent);
    }

    public void avancer(final int ncases) {
        this.cases = this.cases + ncases;
    }

    public void teleporter(final int numeroCase) {
        this.cases = numeroCase;
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
}
