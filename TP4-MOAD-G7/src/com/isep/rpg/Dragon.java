package com.isep.rpg;


public class Dragon extends Enemy{
    public Dragon(String n,int h,int damagePoints) {
        super(n, h, damagePoints);
    }

    @Override
    public void fight(Combattant combattant) {
        combattant.loose( getDamagePoints());
    }

    @Override
    public void setFood(Combattant combattant) {

    }

    public int getDamagePoints() {
        return damagePoints;
    }

}
