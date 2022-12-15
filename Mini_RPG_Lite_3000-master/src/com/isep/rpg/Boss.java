package com.isep.rpg;

import java.util.List;

public class Boss extends Enemy{

    public Boss() {

        super( "Grand Dragon Spectaculaire",10, 1);
            }

    @Override
    public void doAction(List<Combatant> list, List<Combatant> heros, int ixHero) {

    }
    @Override
    public void chooseReward() {

    }
}
