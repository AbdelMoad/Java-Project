package com.isep.rpg;

import java.util.Scanner;

public class Mage extends SpellCaster {

    public Mage(String n,int h, int pp, int mana) {
        super(n,h,pp,mana);
        this.mana=mana;
    }
    public void Protect(Combattant combattant){ combattant.heal(bouclier.getProtectPoints());
    }
    public void setFood(Combattant combattant) { combattant.eat(food.getHealthPoint());
    }

    public void chooseReward() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String reward = scanner.nextLine();
            System.out.println("1 - Plus d'Attaque (+2)");
            System.out.println("2 - Un Repas (3 pts de vie)");
            System.out.println("3 - Plus de mana (+20)");
            switch (reward) {
                case "1":
                    this.tricks.increaseDamagePoints();
                case "2":
                    take(new Food("Repas",3));
                case "3":
                    setMana();
                default:
                    System.out.print("Mauvaise touche !");
            }
        }
    }
    public void setMana(){
        this.mana = mana +20;
    }
    @Override
    public void fight(Combattant combattant) { if (mana!=0) { combattant.loose(tricks.getDamagePoints()); mana=mana-5;
    } else {
        Game.displayMessage("Oups ! Il y a plus de mana");

    }
    }
        // Implémentation de la méthode abstraite "take" par le guerrier :
    //   Le guerrier ne peut utiliser que les objets de type "Weapon"
    @Override
    public void take(Item item) {
        if (item instanceof Tricks) {
            tricks = (Tricks) item;

        }
       else if (item instanceof Food) {
            food = (Food) item;
        }
        else if (item instanceof LifePotion) {
            lifePotion = (LifePotion) item;
        }

        else if (item instanceof Bouclier) {
            bouclier = (Bouclier) item;

        }else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }



    public void setLifePotion(Combattant combattant){combattant.eat(lifePotion.getHealthPoint());}



    private Tricks tricks;

    private Food food;
    private LifePotion lifePotion;
    private Bouclier bouclier;
}
