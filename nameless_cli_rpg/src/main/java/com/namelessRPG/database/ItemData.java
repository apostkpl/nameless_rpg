package com.namelessRPG.database;

import com.namelessRPG.inventory.Item;
import com.namelessRPG.inventory.Potion;
import com.namelessRPG.inventory.Weapon;

public class ItemData {
    private String name;
    private String category;
    private int damage;
    private int healingPoints;

    // Getter functions to retrieve the item details from our database
    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getRecovery() {
        return this.healingPoints;
    }

    // Create Item objects
    public Item toItem() {

        if (this.category.equals("sword") || this.category.equals("axe") || this.category.equals("bow")) {
            // Return Weapons
            return new Weapon(this.name, this.damage, this.category);
        } else if (this.category.equals("potion")) {
            // Return Potions
            return new Potion(this.name, this.healingPoints, this.category);
    } else {
        // Unrecognized type
        System.err.println("Warning: Unknown item type: " + this.category);
        return null; 
    }
}
}