package Controller;

import Model.Carte;
import Model.CarteArgent;
import Model.CarteMouvement;
import Model.CarteTeleportation;
import View.GameInterface;
import Model.CarteProximite;
import Model.CarteSortiePrison;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Game {
        private GameInterface gameinterface;
        private int nb_joueurs;
        private Stack<Carte> pioche;

        public Game() {
                initJoueurs(0);
                pioche=initPioches();
                initCases();
        }

        public void setGUI(final GameInterface gameinterface) {
                this.gameinterface = gameinterface;
        }

        public Stack<Carte> initPioches() { //à faire apres initJoueurs

        CarteTeleportation carte1 = new CarteTeleportation("Carte Téléportation", "Rendez-vous à la Rue de la Paix", false, 39);
        CarteTeleportation carte2 = new CarteTeleportation("Carte Téléportation", "Avancer jusqu’à la case départ", false, 0);
        CarteTeleportation carte3 = new CarteTeleportation("Carte Téléportation", "Rendez-vous à l’Avenue Henri-Martin. Si vous passez par la case départ, recevez 200", false, 24);
        CarteTeleportation carte4 = new CarteTeleportation("Carte Téléportation", "Avancez au Boulevard de La Villette. Si vous passez par la case départ, recevez 200", false, 11);
        CarteTeleportation carte5 = new CarteTeleportation("Carte Téléportation", "Avancez jusqu’à la Gare de Lyon. Si vous passez par la case départ, recevez 200", false, 15);
        CarteTeleportation carte6 = new CarteTeleportation("Carte Téléportation", "Aller en prison. Rendez-vous directement en prison. Ne franchissez pas par la case départ, ne touchez pas 200", false, 10, true);
        CarteTeleportation carte7 = new CarteTeleportation("Carte Téléportation", "Placez-vous sur la case départ", false, 0);
        CarteTeleportation carte8 = new CarteTeleportation("Carte Téléportation", "Aller en prison. Rendez-vous directement à la prison. Ne franchissez pas par la case départ, ne touchez pas 200", false, 10, true);
        CarteTeleportation carte9 = new CarteTeleportation("Carte Téléportation", "Retournez à Belleville", false, 1);
        CarteProximite carte10 = new CarteProximite("Carte Proximite", "Rendez-vous à la gare la plus proche. Si vous passez par la case départ, recevez 200", false);
        CarteSortiePrison carte11= new CarteSortiePrison("Carte à utiliser ou conserver","Vous êtes libéré de prison. Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée ou vendue.",true);
        CarteSortiePrison carte12= new CarteSortiePrison("Carte à utiliser ou conserver","Vous êtes libéré de prison. Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée ou vendue.",true);
        CarteMouvement carte13 = new CarteMouvement("Carte Mouvement", "Reculez de trois cases", false, -3);
        CarteArgent carte14 = new CarteArgent("Carte Argent","Vous êtes imposé pour les réparations de voirie à raison de 50 par maison et 150 par hôtel",false,0);
        CarteArgent carte15 = new CarteArgent("Carte Argent","Vous avez gagné le prix de mots croisés. Recevez 100", false, 100);
        CarteArgent carte16 = new CarteArgent("Carte Argent", "La banque vous verse un dividende de 50", false, 50);
        CarteArgent carte17 = new CarteArgent("Carte Argent", "Faites des réparations dans toutes vos maisons. Versez pour chaque maison 25. Versez pour chaque hôtel 100", false, 0);
        CarteArgent carte18 = new CarteArgent("Carte Argent", "Amende pour excès de vitesse versez 15", false, -15);
        CarteArgent carte19 = new CarteArgent("Carte Argent", "Payez pour frais de scolarité 150", false, -150);
        CarteArgent carte20 = new CarteArgent("Carte Argent", "Amende pour ivresse 20", false, -20);
        CarteArgent carte21 = new CarteArgent("Carte Argent", "Votre immeuble et votre prêt rapportent. Vous devez toucher 150", false, 150);
        CarteArgent carte22 = new CarteArgent("Carte Argent", "Erreur de la banque en votre faveur. Recevez 200", false, 200);
        CarteArgent carte23 = new CarteArgent("Carte Argent", "Payez la note du médecin 50", false, -50);
        CarteArgent carte24 = new CarteArgent("Carte Argent", "La vente de votre stock vous rapporte 50", false, 50);
        CarteArgent carte25 = new CarteArgent("Carte Argent", "Recevez votre revenu annuel 100", false, 100);
        CarteArgent carte26 = new CarteArgent("Carte Argent", "C’est votre anniversaire. Chaque joueur doit vous donner 20", false, (nb_joueurs-1)*20);
        CarteArgent carte27 = new CarteArgent("Carte Argent", "Les contributions vous remboursent la somme de 30", false, 30);
        CarteArgent carte28 = new CarteArgent("Carte Argent", "Recevez votre intérêt sur l’emprunt à 7% égal à 40", false, 40);
        CarteArgent carte29 = new CarteArgent("Carte Argent", "Payez votre Police d’Assurance 50", false, -50);
        CarteArgent carte30 = new CarteArgent("Carte Argent", "Payez une amende de 20", false, -20);
        CarteArgent carte31 = new CarteArgent("Carte Argent", "Vous avez gagné le deuxième Prix de Beauté. Recevez 20", false, 20);
        CarteArgent carte32 = new CarteArgent("Carte Argent", "Vous héritez 100", false, 100);

        Stack<Carte> pioche = new Stack<Carte>();
        pioche.push(carte1);
        pioche.push(carte2);
        pioche.push(carte3);
        pioche.push(carte4);
        pioche.push(carte5);
        pioche.push(carte6);
        pioche.push(carte7);
        pioche.push(carte8);
        pioche.push(carte9);
        pioche.push(carte10);
        pioche.push(carte11);
        pioche.push(carte12);
        pioche.push(carte13);
        pioche.push(carte14);
        pioche.push(carte15);
        pioche.push(carte16);
        pioche.push(carte17);
        pioche.push(carte18);
        pioche.push(carte19);
        pioche.push(carte20);
        pioche.push(carte21);
        pioche.push(carte22);
        pioche.push(carte23);
        pioche.push(carte24);
        pioche.push(carte25);
        pioche.push(carte26);
        pioche.push(carte27);
        pioche.push(carte28);
        pioche.push(carte29);
        pioche.push(carte30);
        pioche.push(carte31);
        pioche.push(carte32);

        Collections.shuffle(pioche);
        return pioche;
        }

        public void initJoueurs(int nb) {
                this.nb_joueurs=nb;
        }

        public void initCases() {

        }

        public void start() {

        }
}
