package com.isep.rpg;


public abstract class Combattant {
    public Combattant(String n, int h) {
        name = n;
        healthPoint = h;
    }
    public String getName() {
        return name;
    }
    public int getHealthPoint() {
        return healthPoint;
    }

    public abstract void fight(Combattant combattant);

    public void loose(int hp) {
        // healthPoint = healthPoint - hp
        healthPoint -= hp;

    }

    private String name;
    private int healthPoint;

}

