package com.isep.rpg;

public class ManaPotion extends Potion {

    public ManaPotion(String name, int mana) {
        super(name, mana);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    // Une potion qui donne des points de vie
    private int mana;
    public void setMana(){
        this.mana = mana +20;
    }
}
