package com.isep.rpg;

public class Warrior extends Hero {

    public Warrior(String n) {
        // Le guerrier possède 5 points de vie
        super(n, 5);
        ;
    }


    @Override
    public void fight(Combatant combatant) {
        combatant.lose( weapon.getDamagePoints());
    }




}