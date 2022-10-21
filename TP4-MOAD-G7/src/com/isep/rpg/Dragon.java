package com.isep.rpg;


public class Dragon extends Enemy{
    public Dragon(String n, int h) {
        super(n, h);
    }

    @Override
    public void fight(Combattant combattant) {
        combattant.loose( 1);
    }
}
