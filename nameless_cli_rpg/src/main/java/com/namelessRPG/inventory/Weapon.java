package com.namelessRPG.inventory;

public class Weapon extends Item {

    private int damage;

    // Weapon Constructor
    public Weapon(String weaponName, int damage, String itemType) {
        super(weaponName, itemType);
        this.damage = damage;
    }
    // Override abstract method
    @Override
    public int use() {
        System.out.printf("You used %s and inflicted %dhp points damage to your opponent!", this.getName(), this.damage);
        return this.damage;
    }
}