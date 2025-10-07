package com.namelessrpg.codex.data;

public class WeaponData {
    // Weapon Properties, as defined in the json file
    private String name;
    private int damage;
    private String category;

    // Constructor
    public WeaponData() {}

    // Getter functions
    public String getName() {
        return this.name;
    }
    public int getDamage() {
        return this.damage;
    }
    public String getCategory() {
        return this.category;
    }
}