package com.isep.rpg;

public class DamagePotion extends Potion {

    public DamagePotion(String name, int damagePoint) {
        super(name, damagePoint);
        this.damagePoint = damagePoint;
    }

    public int getdamagePoint() {
        return damagePoint;
    }

    // Une potion qui donne des points de vie
    private int damagePoint;
}
