package com.isep.rpg;

public class Food extends Consumable {

    public Food(String name, int healthPoint) {
        super(name, healthPoint);
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    // Une nourriture donne des points de vie
    private int healthPoint;
}
