package com.isep.rpg;

import java.util.List;

public class Lezalfos extends Enemy{
    public Lezalfos() {
        // Le Goblin possède 3 points de vie et inflige 0 points de dégats
        super( "Lézalfos",10, 0);

    }

    @Override
    public void doAction(List<Combatant> list, List<Combatant> heros, int ixHero) {

    }
    @Override
    public void chooseReward() {

    }
}

