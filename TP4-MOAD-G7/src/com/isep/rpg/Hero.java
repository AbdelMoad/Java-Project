package com.isep.rpg;

public abstract class Hero extends Combattant{

    protected int protectPoints;

    public Hero(String n, int h,int protectPoints) {
        super(n, h,0);


    }
public abstract void take(Item item);
    public abstract void setFood(Combattant combattant);
    public abstract   void Protect(Combattant combattant);

    public int getProtectPoints() { return protectPoints;
    }
}
