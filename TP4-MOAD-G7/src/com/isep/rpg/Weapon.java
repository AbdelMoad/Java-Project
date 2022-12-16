package com.isep.rpg;

public class Weapon extends Item {

    public Weapon(String name, int damagePoints) {
        super(name, damagePoints);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }
    public void increaseDamagePoints(){
        this.damagePoints= damagePoints +2;
    }

    // Une arme inflige des points de dégats
    private int damagePoints;
}
