package com.isep.rpg;

public abstract class Enemy extends Combattant {
    public Enemy(String n, int h, int damagePoints) {
        super(n, h,0);
        this.damagePoints = damagePoints;
    }
}
