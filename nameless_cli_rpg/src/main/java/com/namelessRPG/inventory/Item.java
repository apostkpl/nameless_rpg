package com.namelessRPG.inventory;

public abstract class Item {
    // Name of the item
    protected String itemName;
    protected String itemCategory;

    // Item object constructor
    public Item(String name, String category) {
        this.itemName = name;
        this.itemCategory = category;
    }
    // Getter method
    public String getName() {
        return this.itemName;
    }
    // Getter method for the type, Sword, Bow, Axe etc
    public String getCategory() {
        return this.itemCategory;
    }

    // Use the item
    public abstract int use(); // To be implemented by specific items
}