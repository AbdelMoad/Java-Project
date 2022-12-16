package com.isep.rpg;

public abstract class Item {


    protected int healthPoint;

    public Item(String name, int h) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

}
