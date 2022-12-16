package com.isep.rpg;

public class Tricks extends Potion {

    public Tricks(String name, int damagePoints) {
        super(name, damagePoints);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void increaseDamagePoints(){
        this.damagePoints= damagePoints +2;
    }

    // Une potion d'attaque inflige des points de dégats
    protected int damagePoints;
}
