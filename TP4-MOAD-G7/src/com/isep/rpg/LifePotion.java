package com.isep.rpg;

public class LifePotion extends Potion {

    public LifePotion(String name, int healthPoint) {
        super(name, healthPoint);
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    // Une potion qui donne des points de vie
    private int healthPoint;
}
