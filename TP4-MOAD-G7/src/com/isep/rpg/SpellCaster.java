package com.isep.rpg;

public abstract class SpellCaster extends Hero {
    int mana;

    public SpellCaster(String n, int h, int mana) {
        super(n, h,0);
        this.mana=mana;
    }
    public abstract void take(Item item);
    protected Potion potion;



}
