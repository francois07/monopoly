package Model;

import java.util.Random;
import java.util.Stack;

public class Plateau {
    private int tour;

    private int taxes;

    private Case cases[];

    private Joueur joueurs[];

    private Stack<Carte> pioche;

    public Plateau(int tour, int taxes, Case cases[], Joueur joueurs[], Stack<Carte> pioche) {
        this.tour = tour;
        this.taxes = taxes;
        this.cases = cases;
        this.joueurs = joueurs;
        this.pioche = pioche;
    }

    public Carte piocher() {
        return this.pioche.pop();
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
