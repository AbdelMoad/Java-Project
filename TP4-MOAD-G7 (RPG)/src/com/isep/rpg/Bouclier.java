package com.isep.rpg;

public class Bouclier extends Item {

    public Bouclier(String name, int protectPoints) {
        super(name, protectPoints);
        this.protectPoints = protectPoints;
    }

    public int getProtectPoints() {
        return protectPoints;
    }

    // Un arc inflige des points de dégats
    private int protectPoints;
}
