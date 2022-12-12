package com.isep.rpg;

public class Healer extends SpellCaster{
    public Healer(String n, int h, int pp,int mana) {
        super(n, h,pp,mana);
        this.mana=mana;
    }
    public void setFood(Combattant combattant) { combattant.eat(food.getHealthPoint());
    }
    public void Protect(Combattant combattant){

        combattant.heal(armures.getProtectPoints());
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
        } else {
            Game.displayMessage("Oups ! " + item.getName() + " est inutile...");
        }
    }

    @Override
    public void fight(Combattant combattant) { if (mana!=0) { combattant.heal(healingSpell.getHealthPoint()); mana=mana-1;
    } else {
        Game.displayMessage("Oups ! Il y a plus de mana");

    }

    }
    private void setMana(Combattant combattant){
        
    }
    private HealingSpell healingSpell;
    private Food food;
private LifePotion lifePotion;
private Armures armures;


}
