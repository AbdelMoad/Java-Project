
package com.isep.rpg;

import java.io.*;

import com.isep.utils.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Game {

    int nbFight;
    private List<Combatant> heros;
    private List<Combatant> enemies;




    public Game(InputParser inputParser) {

        this.inputParser = inputParser;

        heros = new ArrayList<>();
        enemies = new ArrayList<>();

    }

    private void initializeHeros(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choisis le type de héros ou Tape sur Entrée pour Continuer");
            System.out.println("     (1) Guérrier ");
            System.out.println("     (2) Guérisseuse");
            System.out.println("     (3) Mage");
            System.out.println("     (4) Chasseur");
            String herosClass;
            while(true) {
                herosClass = scanner.nextLine();
                if(herosClass.equals("1") || herosClass.equals("guerrier") ||herosClass.equals("Guérrier") || herosClass.equals("2")|| herosClass.equals("guerrisseuse") ||herosClass.equals("Guérisseuse") ||herosClass.equals("3")|| herosClass.equals("mage") || herosClass.equals("Mage") || herosClass.equals("4") ||herosClass.equals("Chasseur") || herosClass.equals("chasseur") ||herosClass.equals("")){
                    break;
                } else {
                    System.out.println("Mauvaise touche, tape sur les bonnes touches !");
                }
            }

            if (herosClass.equals("")) {
                return;
            }
            Hero hero = null;
            String name;
            System.out.println("Quel est son nom ?");
            name = scanner.nextLine();
            switch(herosClass){
                case "Warrior","warrior","1":
                    hero = new Warrior(name);
                    hero.setWeapon("Epée", 5);
                    hero.setArmor("Armure", 2);
                    break;
                case "Healer", "healer", "2":
                    hero = new Healer(name);
                    hero.setWeapon("Potion de guérrison", 2);
                    break;
                case "Mage","mage","3":
                    hero = new Mage(name);
                    hero.setWeapon("Sort d'attaque", 7);
                    break;
                case "Hunter","hunter","4":
                    hero = new Hunter(name);
                    hero.setWeapon("Arc", 6);
                    break;
                default:
                    System.out.println("Mauvaise touche, tape sur les bonnes touches !");
                    break;
            }
            if (hero != null) {
                this.heros.add(hero);
            }
        }
    }

    private void initializeEnemies(){
        Random random = new Random();
        for (int i =0; i< heros.size() +nbFight ; i++) {
            int nb;
            nb = random.nextInt(3);
            switch(nb) {
                case 0:
                    Enemy enemy = new Moblin();
                    enemies.add(enemy);
                    break;
                case 1:
                    Enemy enemy2 = new Lezalfos();
                    enemies.add(enemy2);
                    break;
                case 2:
                    Enemy enemy3 = new Dragon();
                    enemies.add(enemy3);
                    break;
            }
        }
    }

    public void start() {
        System.out.println( "Bonjour, cher Aventurier, \nje suppose que tu sais pourquoi tu es là \nNon? Toujours pas ?" +
                "\nBon, tu dois sauver le monde de l'emprise du Grand Dragon Spectaculaire" +
                "\nTu choisira le type et le nombre d'héros, en fonction de ton choix, des ennemis apparteront ! Prend garde ! \n" +
                "Chaque héros aura 5 repas avec lui, le sorceleur recevra également 5 potions chacun pour régénérer son mana. " );
        System.out.println("Maintenant à toi de libérer le monde entier ! Que la Force soit avec toi !");
        System.out.println();
        Random random = new Random();
        int ixHero = 0;
        int ixEnemy = 0;
        initializeHeros();
        for(int i = 0; i<4;i++){
            initializeEnemies();
            ixHero = random.nextInt(heros.size());
            ixEnemy = random.nextInt(enemies.size());
            // Boucle de jeu
            while (true) {

                displayStatus(heros, enemies);

                Combatant goodOne = heros.get(ixHero);
                Combatant badOne = enemies.get(ixEnemy);

                // Attaque du Hero
                System.out.println("C'est au tour de " + goodOne.getName() + "d'agir !");
                goodOne.doAction(enemies, heros, ixHero);
                if (badOne.getHealthPoint()>0){
                    badOne.fight(goodOne);
                    displayMessage( badOne.getName()
                            + " attaque " + goodOne.getName() + " ! ");
                    if (goodOne.getHealthPoint() <= 0) {
                        displayMessage
                                (goodOne.getName() + " est mort en martyr");
                        heros.remove(ixHero);
                        ixHero--;
                    }
                }


               // }

                // Tests de fin du jeu
                if (heros.size() == 0) {
                    displayMessage("Les héros ont tous péris ! Le Grand Dragon Spectaculaire a gagné !");
                    break;
                }
                if (enemies.size() == 0) {

                    displayMessage("Victoire ! Que la Force soit avec toi pour le prochain combat !");
                    break;
                }

                // Au tour du héro/ennemie suivant
                ixHero = (ixHero + 1) % heros.size();
                ixEnemy = (ixEnemy + 1) % enemies.size();
            }
            System.out.println("############################################################################################");
            for (int n =0; n < heros.size();n++){
                System.out.println("Tu l'a mérité, "+heros.get(n).getName()+" choisis une récompense ! ");
                heros.get(n).chooseReward();
            }
            nbFight++;
        }
        //combat du Boss
        Enemy enemy = new Boss();
        enemies.add(enemy);
        while (true) {
            displayStatus(heros, enemies);
            Combatant goodOne = heros.get(ixHero);
            Combatant badOne = enemies.get(0);

            // Attaque de l'ennemi
            System.out.println("C'est au tour de " + goodOne.getName() + " de faire une action");
            System.out.println(goodOne.getName() + " vise " + badOne.getName());
            goodOne.doAction(enemies, heros, ixHero);

            if (badOne.getHealthPoint()>0){
                badOne.fight(goodOne);
                displayMessage("> " + badOne.getName()
                        + " attaque " + goodOne.getName() + " ! ");
                if (goodOne.getHealthPoint() <= 0) {
                    displayMessage
                            (goodOne.getName() + " est mort en martyr !");
                    heros.remove(ixHero);
                    ixHero--;
                }
            }
            // Tests de fin du jeu

            if (enemies.size() == 0) {
                displayMessage("Bravo, le monde est sauvé ! LONGUE VIE A TOI !!!!");
                break;
            }
            if (heros.size() == 0) {
                displayMessage("Pourtant si prés du but ! Le Grand Dragon Spectaculaire a gagné !");
                break;
            }


            // Au tour du héro suivant
            ixHero = (ixHero + 1) % heros.size();
        }
    }


    private InputParser inputParser;



    // Méthodes d'affichage
    // (STATIQUES pour pouvoir les appeler depuis n'importe où dans le programme)
    //
    // => pourraient éventuellement être déplacées dans le package
    //    "com.isep.utils", en s'inspirant de "InputParser" (méthodes de saisie)

    public static void displayStatus(List<Combatant> h, List<Combatant> e) {

        System.out.println("########################################################################");
        System.out.print(" Héros : ");
        for (Combatant c: h) {
            System.out.print(c.getName() + "(" + c.getHealthPoint()+ "Pts de vie) ");
        }
        System.out.println();
        System.out.print(" Ennemis : ");
        for (Combatant c: e) {
            System.out.print(c.getName() + "(" + c.getHealthPoint() + "Pts de vie) ");
        }
        System.out.println();
        System.out.println("##########################################################################");
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }
}