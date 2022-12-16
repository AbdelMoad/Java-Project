package com.isep.rpg;

import java.util.Scanner;

public class Warrior extends Hero {

    public Warrior(String n,int h,int protectedPoint) {
        super(n, h,protectedPoint);
    }


    @Override
    public void fight(Combattant combattant) { combattant.loose(weapon.getDamagePoints() );

    }

    public void setFood(Combattant combattant) { combattant.eat(food.getHealthPoint());
    }
    public void setLifePotion(Combattant combattant){combattant.eat(lifePotion.getHealthPoint());}

    public void chooseReward() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String reward = scanner.nextLine();
            switch (reward) {
                case "1":
                    weapon.increaseDamagePoints();
                    return;
                case "2":
                    take(new Food("Repas",3));
                    return;
                case "3":
                    setProtectPoints();
                    return;
                default:
                    System.out.print("Mauvaise touche !");
                    return;
            }
        }
    }
    public void setProtectPoints(){
        this.protectPoints = protectPoints +2;
    }
    @Override
    public void Protect(Combattant combattant){ combattant.heal(bouclier.getProtectPoints());
    }

    // Implémentation de la méthode abstraite "take" par le guerrier :
    //   Le guerrier ne peut utiliser que les objets de type "Weapon"
    @Override
    public void take(Item item) {
        if (item instanceof Weapon) {
            weapon = (Weapon) item;
        } else if (item instanceof Food) {
            food = (Food) item;
        }
        else if (item instanceof Bouclier) {
            bouclier = (Bouclier) item;

        }
        else if (item instanceof LifePotion) {
            lifePotion = (LifePotion) item;

        }else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    private Weapon weapon;

    private Food food;
    private LifePotion lifePotion;

    private Bouclier bouclier;
}
