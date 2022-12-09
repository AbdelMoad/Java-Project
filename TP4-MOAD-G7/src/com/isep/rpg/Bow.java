package com.isep.rpg;

public class Bow extends Item {

    public Bow(String name, int damagePoints) {
        super(name, damagePoints);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    // Un arc inflige des points de dégats
    private int damagePoints;
}
