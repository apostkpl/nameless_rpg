package com.namelessrpg.codex.data;

public class PotionData {
    // Potion Properties, as defined in the json file
    private String name;
    private int healingPoints;
    private String category;

    // Constructor
    public PotionData() {}

    // Getter functions
    public String getName() {
        return this.name;
    }
    public int getDamage() {
        return this.healingPoints;
    }
    public String getCategory() {
        return this.category;
    }
}