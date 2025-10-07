package com.namelessRPG.core;

import java.util.Scanner;
import com.namelessRPG.database.ItemData;
import com.namelessRPG.database.ItemApiService;
import com.namelessRPG.inventory.Item;
import java.util.ArrayList;
import java.util.List;
import com.namelessRPG.character.Player;
import com.namelessRPG.character.Warrior;


public class GameEngine {
    private final List<Item> availableItems = new ArrayList<>();
    private final ItemApiService itemApiService = new ItemApiService();
    private Player player;
    private Scanner scanner;

    // Constructor
    public GameEngine() {
        loadGameData();
        this.scanner = new Scanner(System.in);
    }

    // Populate the Inventory with all availableItems. Called by GameEngine.
    private void loadGameData() {
        // Fetch the weapons and potions lists
        List<ItemData> rawWeapons = itemApiService.fetchWeapons();
        List<ItemData> rawPotions = itemApiService.fetchPotions();

        // Convert the List items to actual objects
        for (ItemData data : rawWeapons) {
            Item weapon = data.toItem();
            if (weapon != null) {
                availableItems.add(weapon);
            }
        }
        for (ItemData data : rawPotions) {
            Item potion = data.toItem();
            if (potion != null) {
                availableItems.add(potion);
            }
        }

        // Check if item data was indeed found in our rpg-codex-api
        if (!availableItems.isEmpty()) {
            System.out.printf("Successfully loaded %d items from the API.\n", availableItems.size());
        } else {
            System.err.println("WARNING: Failed to load any items from the API. Check if rpg-codex-api is running!");
        }
    }

    // Getter function for items
    public Item getItemByName(String name) {
        for (Item item : availableItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item; 
            }
        }
        return null;
    }
    
    // Run the story
    public void storyTelling() {
        System.out.println("Welcome to my nameless CLI RPG game. This is a work in progress...");

        // Name your character
        System.out.print("\n Choose your character's name: ");
        String name = scanner.nextLine().trim();
        while (name == null) {
            System.out.print("\nPlease provide a valid name using English characters: ");
            name = scanner.nextLine().trim();
        }

        // Choose your class
        System.out.print("\nChoose your class, Warrior [1], Sorcerer [2], Ranger [3]: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice <1 || choice > 3) {
            System.out.print("\nPlease provide a valid number, 1, 2, or 3: >> ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        // Create the character
        if (choice == 1) {
            player = new Warrior(name);
        }
    }
}