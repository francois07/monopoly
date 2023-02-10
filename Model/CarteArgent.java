package Model;

public class CarteArgent extends Carte {
    private int somme;

    public CarteArgent(String n, String d, boolean st, int so) {
        super(n, d, st);
        this.somme = so;
    }

    public void utiliser(Joueur joueur) {
        joueur.modifierArgent(this.somme);
    }

}
