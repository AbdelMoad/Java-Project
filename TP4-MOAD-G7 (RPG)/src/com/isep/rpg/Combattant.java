package com.isep.rpg;


public abstract class Combattant {
    protected int damagePoints;
    protected int protectPoints;

    public Combattant(String n, int h,int pp) {
        name = n;
        healthPoint = h;
        protectPoints= pp;
    }
    public String getName() {
        return name;
    }
    public int getHealthPoint() {
        return this.healthPoint;
    }

    public int getProtectPoints() {
        return protectPoints;
    }

    public int getManaPoint() {
        return manaPoint;
    }

    public abstract void fight(Combattant combattant);
    public abstract void setFood(Combattant combattant);
    public abstract void Protect(Combattant combattant);

    public abstract void setLifePotion(Combattant combattant);



    
    public void loose(int hp) {
        // healthPoint = healthPoint - hp
        healthPoint -= hp-protectPoints;

    }

    public void protect(int hp) {
        // healthPoint = healthPoint - hp
        damagePoints -= damagePoints;

    }

    public void heal(int hp) {
        healthPoint += hp;

    }
    public void eat(int hp) {
        healthPoint += hp;

    }
    public void ManaSet(int mana){
        mana += mana;
    }

    private String name;
    protected int healthPoint;
    protected int manaPoint;
    public abstract void chooseReward();
}

