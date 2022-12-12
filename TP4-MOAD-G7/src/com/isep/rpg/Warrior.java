package com.isep.rpg;

public class Warrior extends Hero {

    public Warrior(String n,int h,int pp) {
        super(n, h,pp);
        this.protectPoints=protectPoints;
    }


    @Override
    public void fight(Combattant combattant) { combattant.loose(weapon.getDamagePoints() );

    }

    public void setFood(Combattant combattant) { combattant.eat(food.getHealthPoint());
    }
    public void setLifePotion(Combattant combattant){combattant.eat(lifePotion.getHealthPoint());}

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
