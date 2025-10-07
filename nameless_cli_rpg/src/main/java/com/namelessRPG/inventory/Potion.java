package com.namelessRPG.inventory;

public class Potion extends Item {
    private int healingPoints;

    // Weapon Constructor
    public Potion(String name, int points, String category) {
        super(name, category);
        this.healingPoints = points;
    }
    // Override abstract method
    @Override
    public int use() {
        System.out.printf("You used %s, you gained %dhp!", this.getName(), this.healingPoints);
        return this.healingPoints;
    }
}