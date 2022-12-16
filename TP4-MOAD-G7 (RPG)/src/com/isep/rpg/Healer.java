package com.isep.rpg;

import java.util.Scanner;

public class Healer extends SpellCaster{
    public Healer(String n, int h, int pp,int mana) {
        super(n, h,pp,mana);
        this.mana=mana;
    }
    public void setFood(Combattant combattant) { combattant.eat(food.getHealthPoint());
    }
    public void Protect(Combattant combattant){

        combattant.heal(bouclier.getProtectPoints());
    }
    @Override
    public void take(Item item) {
        if (item instanceof HealingSpell) {
       healingSpell  = (HealingSpell) item;
    } else if (item instanceof Food) {
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

    @Override
    public void chooseReward() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String reward = scanner.nextLine();
            System.out.println("1 - Plus d'Attaque (+2)");
            System.out.println("2 - Un Repas (3 pts de vie)");
            System.out.println("3 - Plus de mana (+20)");
            switch (reward) {
                case "1":
                    this.healingSpell.increaseHealthPoints();
                    return;
                case "2":
                    take(new Food("Repas",3));
                    return;
                case "3":
                    setMana();
                    return;
                default:
                    System.out.print("Mauvaise touche !");
            }
        }
    }
    public void setMana(){
        this.mana = mana +20;
    }
    @Override
    public void fight(Combattant combattant) { if (mana!=0) { combattant.heal(healingSpell.getHealthPoint()); mana=mana-5;
    } else {
        Game.displayMessage("Oups ! Il y a plus de mana");

    }


    }


    private Food food;
private LifePotion lifePotion;
private ManaPotion manaPotion;
private HealingSpell healingSpell;
private Bouclier bouclier;



}
