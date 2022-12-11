package com.isep.rpg;

public class Warrior extends Hero {

    public Warrior(String n,int h) {
        super(n, h);
    }


    @Override
    public void fight(Combattant combattant) { combattant.loose(weapon.getDamagePoints() );

    }

    public void setFood(Combattant combattant) { combattant.eat(food.getHealthPoint());
    }


    @Override
    public void Protect(Combattant combattant){ combattant.protect(armures.getProtectPoints());
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
        else if (item instanceof Armures) {
            armures = (Armures) item;

        } else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }


    private Weapon weapon;
    private Food food;

    private Armures armures;

}
