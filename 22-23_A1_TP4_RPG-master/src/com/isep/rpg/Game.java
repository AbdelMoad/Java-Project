package com.isep.rpg;

import com.isep.utils.InputParser;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Game(InputParser inputParser) {

        this.inputParser = inputParser;

        // Il faut normalement 5 héros de types différents...
        heros = new ArrayList<>();
        //
        Hero ronal = new Warrior("Ronal");
        ronal.take( new Weapon("knife", 1) );
        heros.add(ronal);
        //
        Hero conan = new Warrior("Conan");
        conan.take( new Weapon("sword", 2) );
        heros.add(conan);

        // Il faut normalement 5 ennemis de types différents...
        enemies = new ArrayList<>();
        enemies.add( new Dragon("Dracofeu") );
        enemies.add( new Dragon("Smaug") );
    }


    public void start() {

        int ixHero = 0;

        // Boucle de jeu
        while (true) {

            displayStatus(heros, enemies);

            Combatant goodOne = heros.get(ixHero);
            Combatant badOne = enemies.get(0);

            // Attaque de l'ennemi
            displayMessage("Le méchant " + badOne.getName()
                    + " attaque le gentil " + goodOne.getName() + "...");
            badOne.fight(goodOne);
            if (goodOne.getHealthPoint() <= 0) {
                displayMessage("Le pauvre " + goodOne.getName() + " a été vaincu...");
                heros.remove(ixHero);
            } else {

                // Riposte du gentil, s'il n'est pas vaincu
                displayMessage("Le gentil " + goodOne.getName()
                        + " attaque le méchant " + badOne.getName() + "...");
                goodOne.fight(badOne);
                if (badOne.getHealthPoint() <= 0) {
                    displayMessage("Bravo, " + goodOne.getName()
                            + " a vaincu " + badOne.getName() + " !!!");
                    enemies.remove(0);
                }

            }

            // Tests de fin du jeu
            if (heros.size() == 0) {
                displayMessage("Les héros ont perdu, c'est la fin du monde...");
                break;
            }
            if (enemies.size() == 0) {
                displayMessage("BRAVO, les héros ont gagné, le monde est sauvé !!!");
                break;
            }

            // Au tour du héro suivant
            ixHero = (ixHero + 1) % heros.size();
        }
    }


    private InputParser inputParser;

    private List<Combatant> heros;
    private List<Combatant> enemies;


    // Méthodes d'affichage
    // (STATIQUES pour pouvoir les appeler depuis n'importe où dans le programme)
    //
    // => pourraient éventuellement être déplacées dans le package
    //    "com.isep.utils", en s'inspirant de "InputParser" (méthodes de saisie)

    public static void displayStatus(List<Combatant> h, List<Combatant> e) {
        System.out.println("#########################");
        for (Combatant c: h) {
            System.out.print(c.getName() + "(" + c.getHealthPoint() + ") ");
        }
        System.out.println();
        for (Combatant c: e) {
            System.out.print(c.getName() + "(" + c.getHealthPoint() + ") ");
        }
        System.out.println();
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }
}
