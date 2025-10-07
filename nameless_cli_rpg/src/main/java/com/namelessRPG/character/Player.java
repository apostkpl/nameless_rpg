package com.namelessRPG.character;
import com.namelessRPG.inventory.Inventory;
import com.namelessRPG.inventory.Item;
import com.namelessRPG.inventory.Weapon;
import com.namelessRPG.inventory.Potion;

public abstract class Player {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected Inventory inventory;
    protected Weapon currentWeapon;

    // Constructor
    public Player(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Newly created players start with max health
        this.inventory = new Inventory(); // Newly created players start with an empty inventory
        this.currentWeapon = null; // Newly created players don't hold any weapons yet
    }

    // Getter methods
    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public Weapon getCurrentWeapon() {
        return this.currentWeapon;
    }

    // Attack method, to be implemented for each type of character
    public abstract int attack();

    public void setHealth(int points) {
        if (this.health + points >= this.maxHealth) {
            this.health = maxHealth;
        } else if (this.health + points < 1) {
            this.health = 1; // No logic for character dying yet
        } else {
            this.health += points; // points can be a negative int, to inflict damage
        }
    }

    // Utilise items
    public void useItem(String itemName) {
        Item item = this.inventory.getItem(itemName);
        if (item != null) {
            if (item instanceof Potion) {
                int points = item.use();
                this.setHealth(points);
                System.out.printf("\nYou used %s, %dhp were added to your health.\n", itemName, points);
            }
        }
    }
    // Equip weapons
    public void equipWeapon(String weaponName) {
        Item weapon = this.inventory.getItem(weaponName);
        if (weapon != null) {
            if (weapon instanceof Weapon) {
                this.currentWeapon = (Weapon) weapon;
                System.out.printf("% equipped!", weaponName);
            }
        }
    }

    // Display character stats
    public void playerInfo() {
        System.out.println("\n----------------Player Stats: ----------------");
        System.out.printf("Name: %s", this.getName());
        System.out.printf("\nHealth: %d", this.getHealth());
        if (this.getCurrentWeapon() != null) {
            System.out.printf("\nCurrent Weapon: %s", this.getCurrentWeapon().getName());
        }
    }
}