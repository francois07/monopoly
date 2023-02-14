package Controller;

import Model.Carte;
import Model.CarteArgent;
import Model.CarteMouvement;
import Model.CarteTeleportation;
import Model.Case;
import Model.CaseCategorie;
import Model.CasePropriete;
import Model.Propriete;
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
                initProperties();
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

        public void initProperties() {
                CasePropriete case1=new CasePropriete("Boulevard de Belleville", CaseCategorie.CASE_NORMALE, new Propriete("Boulevard de Belleville", new int[] {60,50,50,50,50,50}, new int[] {2,10,30,90,160,250}, null));
                CasePropriete case3=new CasePropriete("Rue Lecourbe", CaseCategorie.CASE_NORMALE, new Propriete("Rue Lecourbe", new int[] {60,50,50,50,50,50}, new int[] {4,20,60,180,320,450}, null));
                CasePropriete case6=new CasePropriete("Rue de Vaugirard", CaseCategorie.CASE_NORMALE, new Propriete("Rue de Vaugirard", new int[] {100,50,50,50,50,50}, new int[] {6,30,90,270,400,550}, null));
                CasePropriete case8=new CasePropriete("Rue de Courcelles", CaseCategorie.CASE_NORMALE, new Propriete("Rue de Courcelles", new int[] {100,50,50,50,50,50}, new int[] {6,30,90,270,400,550}, null));
                CasePropriete case9=new CasePropriete("Avenue de la République", CaseCategorie.CASE_NORMALE, new Propriete("Avenue de la république", new int[] {120,50,50,50,50,50}, new int[] {8,40,100,300,450,600}, null));
                CasePropriete case11=new CasePropriete("Boulebard de la Villette", CaseCategorie.CASE_NORMALE, new Propriete("Boulebard de la Villette", new int[] {140,100,100,100,100,100}, new int[] {10,50,150,450,625,750}, null));
                CasePropriete case13=new CasePropriete("Avenue de Neuilly", CaseCategorie.CASE_NORMALE, new Propriete("Avenue de Neuilly", new int[] {140,100,100,100,100,100}, new int[] {10,50,150,450,625,750}, null));
                CasePropriete case14=new CasePropriete("Rue de Paradis", CaseCategorie.CASE_NORMALE, new Propriete("Rue de Paradis", new int[] {160,100,100,100,100,100}, new int[] {12,60,180,500,700,900}, null));
                CasePropriete case16=new CasePropriete("Avenue Mozart", CaseCategorie.CASE_NORMALE, new Propriete("Avenue Mozart", new int[] {180,100,100,100,100,100}, new int[] {14,70,200,550,750,950}, null));
                CasePropriete case18=new CasePropriete("Boulevard Saint-Michel", CaseCategorie.CASE_NORMALE, new Propriete("Boulevard Saint-Michel", new int[] {180,100,100,100,100,100}, new int[] {14,70,200,550,750,950}, null));
                CasePropriete case19=new CasePropriete("Place Pigalle", CaseCategorie.CASE_NORMALE, new Propriete("Place Pigalle", new int[] {200,100,100,100,100,100}, new int[] {16,80,220,600,800,1000}, null));
                CasePropriete case21=new CasePropriete("Avenue Matignon", CaseCategorie.CASE_NORMALE, new Propriete("Avenue Matignon", new int[] {220,150,150,150,150,150}, new int[] {18,90,250,700,875,1050}, null));
                CasePropriete case23=new CasePropriete("Boulevard Malesherbes", CaseCategorie.CASE_NORMALE, new Propriete("Boulevard Malesherbes", new int[] {220,150,150,150,150,150}, new int[] {18,90,250,700,875,1050}, null));
                CasePropriete case24=new CasePropriete("Avenue Henri-Martin", CaseCategorie.CASE_NORMALE, new Propriete("Avenue Henri-Martin", new int[] {240,150,150,150,150,150}, new int[] {20,100,300,750,925,1100}, null));
                CasePropriete case26=new CasePropriete("Faubourg Saint-Honoré", CaseCategorie.CASE_NORMALE, new Propriete("Faubourg Saint-Honoré", new int[] {260,150,150,150,150,150}, new int[] {22,110,330,800,975,1150}, null));
                CasePropriete case27=new CasePropriete("Place de la Bourse", CaseCategorie.CASE_NORMALE, new Propriete("Place de la Bourse", new int[] {260,150,150,150,150,150}, new int[] {22,110,330,800,975,1150}, null));
                CasePropriete case29=new CasePropriete("Rue la Fayette", CaseCategorie.CASE_NORMALE, new Propriete("Rue la Fayette", new int[] {280,150,150,150,150,150}, new int[] {24,120,360,850,1025,1200}, null));
                CasePropriete case31=new CasePropriete("Avenue de Breteuil", CaseCategorie.CASE_NORMALE, new Propriete("Avenue de Breteuil", new int[] {300,200,200,200,200,200}, new int[] {26,130,390,900,1100,1275}, null));
                CasePropriete case32=new CasePropriete("Avenue Foch", CaseCategorie.CASE_NORMALE, new Propriete("Avenue Foch", new int[] {300,200,200,200,200,200}, new int[] {26,130,390,900,1100,1275}, null));
                CasePropriete case34=new CasePropriete("Boulevard des Capucines", CaseCategorie.CASE_NORMALE, new Propriete("Boulevard des Capucines", new int[] {320,200,200,200,200,200}, new int[] {28,150,450,1000,1200,1400}, null));
                CasePropriete case37=new CasePropriete("Avenue des Champs-Elysées", CaseCategorie.CASE_NORMALE, new Propriete("Avenue des Champs-Elysées", new int[] {350,200,200,200,200,200}, new int[] {35,175,500,1100,1300,1500}, null));
                CasePropriete case39=new CasePropriete("Rue de la Paix", CaseCategorie.CASE_NORMALE, new Propriete("Rue de la Paix", new int[] {400,200,200,200,200,200}, new int[] {50,200,600,1400,1700,2000}, null));
                
        }

        public void start() {

        }
}
