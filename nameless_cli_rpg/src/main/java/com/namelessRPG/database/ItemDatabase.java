package com.namelessRPG.database;

import java.util.List;

public class ItemDatabase {
    private List<ItemData> weapons;
    private List<ItemData> potions;

    // Getters for the two database categories of items
    public List<ItemData> getWeapons() {
        return weapons;
    }

    public List<ItemData> getPotions() {
        return potions;
    }
}