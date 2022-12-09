package com.isep.rpg;

public class LifePotion extends Consumable {

    public LifePotion(String name) {
        super(name,5);
        this.healthPoint = healthPoint;

    }

    public int getHealthPoint() {
        return healthPoint;
    }

    // Une potion qui donne des points de vie
    private int healthPoint;
}
