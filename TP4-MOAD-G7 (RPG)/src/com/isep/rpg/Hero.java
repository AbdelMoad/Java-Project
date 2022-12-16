package com.isep.rpg;

public abstract class Hero extends Combattant{

    protected int protectPoints;


    public Hero(String n, int h,int protectPoints) {
        super(n, h,protectPoints);


    }
public abstract void take(Item item);
    public abstract void setFood(Combattant combattant);
    public abstract   void Protect(Combattant combattant);
    public abstract void setLifePotion(Combattant combattant);
    public int getProtectPoints() { return protectPoints;
    }
}
