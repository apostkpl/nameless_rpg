package com.namelessRPG.inventory;

// Necessary Libraries
import java.util.Map;
import java.util.HashMap;

public class Inventory {
    // Items inside the player's inventory
    private Map<String, Item> items = new HashMap<>();
    private static final int MAX_SIZE = 15; // May need to change the size, time will tell

    // Getter method for an item
    public Item getItem(String itemName) {
        return this.items.get(itemName);
    }

    // Add to player's inventory
    public boolean addItem(Item item) {
        if (items.size() >= MAX_SIZE) {
            System.out.println("\nInventory already full. Drop an item if you want to be able to carry this one.");
            return false;
        }
        this.items.put(item.getName(), item);
        System.out.printf("\nItem [ %s ] acquired!\n", item.getName());
        return true;
    }

    //  Remove from player's inventory
    public boolean removeItem(String itemName) {

        // Check for Null values or empty input
        if (itemName == null || itemName.strip().isEmpty()) {
            System.out.println("Invalid item name.");
            return false;
        }

        if (this.items.containsKey(itemName)) {
            items.remove(itemName);
            System.out.printf("\nItem [ %s ] removed successfully.\n", itemName);
            return true;
        } else {
            System.out.printf("\nItem [ %s ] not found in your inventory.\n", itemName);
            return false;
        }
    }

    // Get the list of available items
    public void printItems() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty");
        }
        System.out.println("--------YOUR INVENTORY--------");
        for (String itemName : items.keySet()) {
            System.out.println(itemName);
        }
        System.out.println("------------------------------");
    }
}