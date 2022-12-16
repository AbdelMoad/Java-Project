package com.isep.rpg;

public class HealingSpell extends Potion {

    public HealingSpell(String name, int healthPoint) {
        super(name, healthPoint);
        this.healthPoint = healthPoint;

    }

    public int getHealthPoint() {
        return healthPoint;
    }
    public void increaseHealthPoints(){
        this.healthPoint= healthPoint +2;
    }


    // Une sort guérit
    protected int healthPoint;

}
