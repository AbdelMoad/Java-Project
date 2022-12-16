package com.isep.rpg;

public class DefensePotion extends Potion {

    public DefensePotion(String name, int healthPoint) {
        super(name, healthPoint);
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    // Une potion qui donne des points de vie
    private int healthPoint;
}
