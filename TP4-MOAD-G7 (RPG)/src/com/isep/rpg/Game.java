package com.isep.rpg;

import java.io.*;

import com.isep.utils.ConsoleParser;
import com.isep.utils.InputParser;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import javax.sound.sampled.*;

public class Game {


    private List<Combattant> heros;
    private List<Combattant> enemies;


    public Game(InputParser inputParser) {
        inputParser = new ConsoleParser();
        this.inputParser = inputParser;
        System.out.println("Bienvenue sur Mini RPG Lite 300");
        System.out.println("Le monde est envahi par les dragons, il faut le sauver !");
        System.out.println("Pour cela vous aurez besoin d'appeler des héros. Mais 4 Types de héros s'offrent à vous :");
        System.out.println("les guérriers, les guérisseuses, les mages et les chasseurs.");
        System.out.println("Vous pourrez utiliser autant d'héros que vous voulez ! A vous de jouer !");
        int choix = 0;
        // Il faut normalement 5 héros de types différents...
        heros = new ArrayList<>();

        while (choix != 5) {
            System.out.println("Quel est ton choix ?");
            System.out.println(" 1- Guerrier");
            System.out.println(" 2- Chasseur");
            System.out.println(" 3 - Guérisseuse");
            System.out.println(" 4 - Mage");
            System.out.println(" 5 - Commencer la partie");
            Scanner sc = new Scanner(System.in);
            choix = sc.nextInt();
            if (choix == 1) {
                Hero ronal = new Warrior("Warrior", 10, 2);
                ronal.take(new Weapon("knife", 5));
                ronal.take(new Food("Apple", 1));
                ronal.take(new Bouclier("Warrior Armures", 3));
                ronal.take(new LifePotion("Warrior Armures", 5));
                heros.add(ronal);
                System.out.println("Combien ?");
                int n = sc.nextInt();
                for (int i = 2; i <= n; i++) {
                    Hero ronal2 = new Warrior("Warrior" + i, 10, 2);
                    ronal2.take(new Weapon("knife", 5));
                    ronal2.take(new Food("Apple", 1));
                    ronal2.take(new Bouclier("Warrior Armures", 3));
                    ronal2.take(new LifePotion("Warrior Armures", 5));
                    heros.add(ronal2);

                }
            }
            if (choix == 2) {
                Hero joe = new Hunter("Hunter", 8, 2, 20);
                joe.take(new Bow("Arc", 6));
                joe.take(new Food("Apple", 1));
                joe.take(new LifePotion("Potion de vie", 5));
                joe.take(new Bouclier("Warrior Armures", 3));
                heros.add(joe);
                System.out.println("Combien ?");
                int n = sc.nextInt();
                for (int i = 2; i <= n; i++) {
                    Hero joe2 = new Hunter("Hunter" + i, 8, 2, 20);
                    joe2.take(new Bow("Arc", 6));
                    joe2.take(new Food("Apple", 1));
                    joe2.take(new Bouclier("Warrior Armures", 3));
                    joe2.take(new LifePotion("Warrior Armures", 5));
                    heros.add(joe2);

                }

            }
            if (choix == 3) {
                Hero diana = new Healer("Healer", 15, 5, 5);
                diana.take(new HealingSpell("Sort de guérison", 5));
                diana.take(new Food("Apple", 1));
                diana.take(new LifePotion("Potion de vie", 5));
                diana.take(new Bouclier("Warrior Armures", 3));
                heros.add(diana);
                System.out.println("Combien ?");
                int n = sc.nextInt();
                for (int i = 2; i <= n; i++) {
                    Hero diana2 = new Healer("Healer" + i, 15, 5, 5);
                    diana2.take(new HealingSpell("Sort de guérison", 5));
                    diana2.take(new Food("Apple", 1));
                    diana2.take(new LifePotion("Potion de vie", 5));
                    diana2.take(new Bouclier("Warrior Armures", 3));
                    heros.add(diana2);
                }
            }
            if (choix == 4) {
                Hero merlin = new Mage("Mage", 5, 20, 20);
                merlin.take(new Tricks("Sort d'Attaque", 10));
                merlin.take(new Food("Apple", 1));
                merlin.take(new LifePotion("Potion de vie", 5));
                merlin.take(new Bouclier("Warrior Armures", 3));
                heros.add(merlin);
                System.out.println("Combien ?");
                int n = sc.nextInt();
                for (int i = 2; i <= n; i++) {
                    Hero merlin2 = new Mage("Mage" + i, 5, 20, 20);
                    merlin2.take(new Tricks("Sort d'Attaque", 6));
                    merlin2.take(new Food("Apple", 1));
                    merlin2.take(new LifePotion("Potion de vie", 5));
                    merlin2.take(new Bouclier("Warrior Armures", 3));
                    heros.add(merlin);
                }
            }
            // Il faut normalement 5 ennemis de types différents...



        }
        enemies = new ArrayList<>();
        for (Combattant elem : heros) {
            if (elem instanceof Warrior) {
                enemies.add(new Dragon("Dracofeu", 8, 6));
            }
            if (elem instanceof Hunter) {
                enemies.add(new Dragon("Smaug", 7, 7));
            }
            if (elem instanceof Mage) {
                enemies.add(new Dragon("Tornado", 15, 3));
            }
            if (elem instanceof Healer) {
                enemies.add(new Dragon("Morticus", 15, 5));
            }
        }
    }

    public void handleInput(String input) {
        inputParser.parseInput(input, this);
    }


    public void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File mp3File = new File("C:\\Users\\moad\\Downloads\\_-RPG-Exploration-Music-Song-Of-The-Night.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(mp3File);

        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        int ixHero = 0;
        int ixEnemy = 0;


        // Boucle de jeu


            while (true) {



                ixHero = 0;
                ixEnemy = 0;


                displayStatus(heros, enemies);

                Combattant goodOne = heros.get(ixHero);
                Combattant badOne = enemies.get(ixEnemy);


                Scanner sc = new Scanner(System.in);
                System.out.println("Quel est ton choix ?");
                System.out.println(" 1- Attaque/Guérir");
                System.out.println(" 2- Nourriture");
                System.out.println(" 3- Se défendre");
                System.out.println(" 4- Potion de vie");
                int choix = sc.nextInt();
                if (choix == 1) { // Riposte du gentil, s'il n'est pas vaincu
                    displayMessage("Le gentil " + goodOne.getName()
                            + " attaque le méchant " + badOne.getName() + "...");
                    if (goodOne instanceof Healer) {
                        for (Combattant elem : heros) {
                            goodOne.fight(elem);
                        }

                    } else {
                        goodOne.fight(badOne);
                    }
                } else if (choix == 2) {
                    goodOne.setFood(goodOne);
                } else if (choix == 3) {
                    goodOne.Protect(goodOne);
                } else if (choix == 4) {
                    goodOne.setLifePotion(goodOne);

                }

                if (badOne.getHealthPoint() > 0) {
                    // Attaque de l'ennemi
                    displayMessage("Le méchant " + badOne.getName()
                            + " attaque le gentil " + goodOne.getName() + "...");
                    badOne.fight(goodOne);
                    if (goodOne.getHealthPoint() <= 0) {
                        displayMessage("Le pauvre " + goodOne.getName() + " a été vaincu...");


                        heros.remove(ixHero);

                    }
                } else {
                    displayMessage("Le méchant " + badOne.getName() + " a été vaincu...");
                    enemies.remove(ixEnemy);

                                    }

                // Tests de fin du jeu
                if (heros.size() == 0) {

                    displayMessage("Les héros ont perdu, c'est la fin du monde...");

                    break;


                }
                if (enemies.size() == 0) {

                    displayMessage("BRAVO, le monde est sauvé !!!");
                    System.out.println("############################################################################################");
                    for (Combattant elem: heros){
                        System.out.println("Tu l'a mérité, "+elem.getName()+" choisis une récompense ! ");

                        elem.chooseReward();

                    }

                    break;
                }


                ixHero = (ixHero + 1 )% heros.size();


        }



        // Boucle de jeu


        while (true) {



            ixHero = 0;
            ixEnemy = 0;


            displayStatus(heros, enemies);

            Combattant goodOne = heros.get(ixHero);
            Combattant badOne = enemies.get(ixEnemy);


            Scanner sc = new Scanner(System.in);
            System.out.println("Quel est ton choix ?");
            System.out.println(" 1- Attaque/Guérir");
            System.out.println(" 2- Nourriture");
            System.out.println(" 3- Se défendre");
            System.out.println(" 4- Potion de vie");
            int choix = sc.nextInt();
            if (choix == 1) { // Riposte du gentil, s'il n'est pas vaincu
                displayMessage("Le gentil " + goodOne.getName()
                        + " attaque le méchant " + badOne.getName() + "...");
                if (goodOne instanceof Healer) {
                    for (Combattant elem : heros) {
                        goodOne.fight(elem);
                    }

                } else {
                    goodOne.fight(badOne);
                }
            } else if (choix == 2) {
                goodOne.setFood(goodOne);
            } else if (choix == 3) {
                goodOne.Protect(goodOne);
            } else if (choix == 4) {
                goodOne.setLifePotion(goodOne);

            }

            if (badOne.getHealthPoint() > 0) {
                // Attaque de l'ennemi
                displayMessage("Le méchant " + badOne.getName()
                        + " attaque le gentil " + goodOne.getName() + "...");
                badOne.fight(goodOne);
                if (goodOne.getHealthPoint() <= 0) {
                    displayMessage("Le pauvre " + goodOne.getName() + " a été vaincu...");


                    heros.remove(ixHero);

                }
            } else {
                displayMessage("Le méchant " + badOne.getName() + " a été vaincu...");
                enemies.remove(ixEnemy);

            }

            // Tests de fin du jeu
            if (heros.size() == 0) {

                displayMessage("Les héros ont perdu, c'est la fin du monde...");

                break;


            }
            if (enemies.size() == 0) {

                displayMessage("BRAVO, le monde est sauvé !!!");
                System.out.println("############################################################################################");
                for (Combattant elem: heros){
                    System.out.println("Tu l'a mérité, "+elem.getName()+" choisis une récompense ! ");

                    elem.chooseReward();

                }

                break;
            }


            ixHero = (ixHero + 1 )% heros.size();


        }

    }

    private InputParser inputParser;





            // Méthodes d'affichage
            // (STATIQUES pour pouvoir les appeler depuis n'importe où dans le programme)
            //
            // => pourraient éventuellement être déplacées dans le package
            //    "com.isep.utils", en s'inspirant de "InputParser" (méthodes de saisie)

            public static void displayStatus (List < Combattant > h, List < Combattant > e){
                System.out.println("#########################");
                for (Combattant c : h) {
                    System.out.print(c.getName() + "(Pts de vie :" + c.getHealthPoint() + ") )");
                }
                System.out.println();
                for (Combattant c : e) {
                    System.out.print(c.getName() + "(Pts de vie :"+ c.getHealthPoint() + ") ");
                }
                System.out.println();
            }

            public static void displayMessage (String message){
                System.out.println(message);
            }
        }

