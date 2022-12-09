package com.isep.rpg;


public abstract class Combattant {
    protected int damagePoints;

    public Combattant(String n, int h) {
        name = n;
        healthPoint = h;
    }
    public String getName() {
        return name;
    }
    public int getHealthPoint() {
        return this.healthPoint;
    }

    public abstract void fight(Combattant combattant);
    public abstract void setFood(Combattant combattant);


    
    public void loose(int hp) {
        // healthPoint = healthPoint - hp
        healthPoint -= hp;

    }

    public void heal(int hp) {
        healthPoint += hp;

    }
    public void eat(int hp) {
        healthPoint += hp;

    }

    private String name;
    protected int healthPoint;

}

