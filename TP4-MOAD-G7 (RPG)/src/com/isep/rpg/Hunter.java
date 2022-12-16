package com.isep.rpg;

import java.util.Scanner;

public class Hunter extends Hero {
    public Hunter(String n,int h,int pp,int arrow) {
        super(n,h,pp);
       this.arrow=arrow;

    }
    public void setFood(Combattant combattant) { combattant.eat(food.getHealthPoint());
    }

    @Override
    public void Protect(Combattant combattant){ combattant.heal(bouclier.getProtectPoints());
    }
    public void setLifePotion(Combattant combattant){combattant.eat(lifePotion.getHealthPoint());}


    private int arrow;



    public void chooseReward() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String reward = scanner.nextLine();
            switch (reward) {
                case "1":
                    this.bow.increaseDamagePoints();
                    return;
                case "2":
                    take(new Food("Repas",3));
                    return;
                case "3":
                    setProtectPoints();
                    return;
                default:
                    System.out.print("Mauvaise touche !");
            }
        }
    }
    public void setProtectPoints(){
        this.protectPoints = protectPoints +2;
    }

    @Override
    public void fight(Combattant combattant) { if (arrow!=0) { combattant.loose(bow.getDamagePoints()); arrow=arrow-1;
        } else {Game.displayMessage("Oups ! Il y a plus de fleches");}


    }
    // Implémentation de la méthode abstraite "take" par le guerrier :
    //   Le guerrier ne peut utiliser que les objets de type "Weapon"
    @Override
    public void take(Item item) {
        if (item instanceof Bow) {
            bow = (Bow) item;
        } else if (item instanceof Food) {
            food = (Food) item;
        }
        else if (item instanceof LifePotion) {
            lifePotion = (LifePotion) item;
        }
        else if (item instanceof Bouclier) {
            bouclier = (Bouclier) item;

        }
        else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    private Bow bow;

    private LifePotion lifePotion;
    private Food food;
    private Bouclier bouclier;
}
