package com.isep.rpg;

public abstract class Hero extends Combattant{

    public Hero(String n, int h) {
        super(n, h);
    }
public abstract void take(Item item);
    public abstract void setFood(Combattant combattant);
    public abstract   void Protect(Combattant combattant);
}
