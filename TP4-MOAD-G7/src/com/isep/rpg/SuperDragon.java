package com.isep.rpg;


public class SuperDragon extends Enemy{
    public SuperDragon(String n) {
        super(n, 20, 6);
    }

    @Override
    public void fight(Combattant combattant) {
        combattant.loose( getDamagePoints());
    }

    @Override
    public void setFood(Combattant combattant) {

    }
    public void Protect(Combattant combattant){
    }
    public void setLifePotion(Combattant combattant){}

    @Override
    public void chooseReward() {

    }

    public int getDamagePoints() {
        return damagePoints;
    }

}
