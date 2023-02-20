package Model.Cartes;

import Model.Joueur;

public class CarteArgent extends Carte {
    private int somme;

    public CarteArgent(String n, String d, boolean st, int so) {
        super(n, d, st);
        this.somme = so;
    }

    public void utiliser(Joueur joueur) {
        joueur.getPlateau().getGUI().println(String.format("Vous gagnez %d francs", this.somme));
        joueur.ajouterArgent(this.somme);
    }

}
