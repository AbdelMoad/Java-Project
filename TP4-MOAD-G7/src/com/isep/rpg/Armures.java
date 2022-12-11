package com.isep.rpg;

public class Armures extends Item {

    public Armures(String name, int protectPoints) {
        super(name, protectPoints);
        this.protectPoints = protectPoints;
    }

    public int getProtectPoints() {
        return protectPoints;
    }

    // Un arc inflige des points de dégats
    private int protectPoints;
}
