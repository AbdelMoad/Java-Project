package com.isep.rpg;

import java.util.List;

public class Moblin extends Enemy{
    public Moblin() {
        // Le Goblin possède 3 points de vie et inflige 0 points de dégats
        super( "Moblin",10, 0);
            }

    @Override
    public void doAction(List<Combatant> list, List<Combatant> heros, int ixHero) {

    }
    @Override
    public void chooseReward() {

    }
}
