package Controller;

import Model.Carte;
import Model.CarteArgent;
import Model.CarteMouvement;
import Model.CarteTeleportation;
import View.GameInterface;
import Model.CarteProximite;
import Model.CarteSortiePrison;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Game {
        private GameInterface gameinterface;

        public Game() {

        }

        public void setGUI(final GameInterface gameinterface) {
                this.gameinterface = gameinterface;
        }

        // public Stack<Carte> initPioche() {

        // CarteTeleportation carte1 = new CarteTeleportation("Carte Téléportation",
        // "Rendez-vous à la Rue de la Paix",
        // false, 0);
        // CarteTeleportation carte2 = new CarteTeleportation("Carte Téléportation",
        // "Avancer jusqu’à la case départ",
        // false, 0);
        // CarteTeleportation carte3 = new CarteTeleportation("Carte Téléportation",
        // "Rendez-vous à l’Avenue Henri-Martin. Si vous passez par la case départ,
        // recevez 200", false, 0);
        // CarteTeleportation carte4 = new CarteTeleportation("Carte Téléportation",
        // "Avancez au Boulevard de La Villette. Si vous passez par la case départ,
        // recevez 200", false, 0);
        // CarteTeleportation carte5 = new CarteTeleportation("Carte Téléportation",
        // "Avancez jusqu’à la Gare de Lyon. Si vous passez par la case départ, recevez
        // 200", false, 0);
        // CarteTeleportation carte6 = new CarteTeleportation("Carte Téléportation",
        // "Aller en prison. Rendez-vous directement en prison. Ne franchissez pas par
        // la case départ, ne touchez pas 200",
        // false, 0);
        // CarteTeleportation carte7 = new CarteTeleportation("Carte Téléportation",
        // "Placez-vous sur la case départ",
        // false, 0);
        // CarteTeleportation carte8 = new CarteTeleportation("Carte Téléportation",
        // "Aller en prison. Rendez-vous directement à la prison. Ne franchissez pas par
        // la case départ, ne touchez pas 200",
        // false, 0);
        // CarteTeleportation carte9 = new CarteTeleportation("Carte Téléportation",
        // "Retournez à Belleville", false, 0);
        // CarteProximite carte10 = new CarteProximite("Carte Proximite",
        // "Rendez-vous à la gare la plus proche. Si vous passez par la case départ,
        // recevez 200", false);
        // CarteSortiePrison carte11= new CarteSortiePrison("Carte à utiliser ou
        // conserver","Vous êtes libéré de prison. Cette carte peut être conservée
        // jusqu’à ce qu’elle soit utilisée ou vendue.",true);
        // CarteSortiePrison carte12= new CarteSortiePrison("Carte à utiliser ou
        // conserver","Vous êtes libéré de prison. Cette carte peut être conservée
        // jusqu’à ce qu’elle soit utilisée ou vendue.",true);
        // CarteMouvement carte13 = new CarteMouvement("Carte Mouvement", "")

        // }

        public void initJoueur() {

        }

        public void initCases() {

        }

        public void start() {

        }
}
