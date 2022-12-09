package com.isep.rpg;

public class Hunter extends Hero {
    public Hunter(String n,int h,int arrow) {
        super(n,h);
       this.arrow=arrow;
    }
    public void setFood(Combattant combattant) { combattant.eat(food.getHealthPoint());
    }

    private int arrow;
    @Override
    public void fight(Combattant combattant) { if (arrow!=0) { combattant.loose(bow.getDamagePoints()); arrow=arrow-1;
        } else {Game.displayMessage("Oups ! Il y a plus de fleches");} ;

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
        else if (item instanceof Potion) {
            potion = (Potion) item;
        } else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    private Bow bow;
    private Potion potion;
    private Food food;
}
