package com.isep.rpg;

public class Mage extends SpellCaster {

    public Mage(String n,int h, int mana) {
        super(n,h,mana);
        this.mana=mana;
    }
    public void setFood(Combattant combattant) { combattant.eat(food.getHealthPoint());
    }
    @Override
    public void fight(Combattant combattant) { if (mana!=0) { combattant.loose(tricks.getDamagePoints()); mana=mana-1;
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
        else if (item instanceof Potion) {
            lifePotion = (LifePotion) item;
        } else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }


    public void heal(Combattant combattant) {

    }


    private Tricks tricks;
    private Food food;
    private LifePotion lifePotion;
}
