package com.isep.rpg;

public abstract class Consumable extends Item {
    public Consumable(String n, int h) {
        super(n,h);


    }

    public int getHealthPoint() {
        return healthPoint;
    }






}
