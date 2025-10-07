package com.namelessRPG.character;

public class Warrior extends Player {
    private double strength;

    // Constructor
    public Warrior(String name) {
        super(name, 100);
        this.strength = 1.6;
    }

    // Getter for strength (which doesn't exist in the parent class)
    public double getStrength() {
        return this.strength;
    }

    // Level up for strength
    public boolean levelUpStrength(double percent) {
        if (percent <= 0 || percent > 1) {
            System.out.printf("\nError leveling up %s, the leveling up must be proportional. Please rport back.\n", this.getName());
            return false;
        } else {
            this.strength += this.strength * percent;
            System.out.printf("\nYour warrior leveled up. Their strength is now %.2f.", this.getStrength());
            return true;
        }
    }

    // Override the abstract attack method
    @Override
    public int attack() {
        // Weapon bonus for Swords
        double weaponBonus = 1.0;
        
        if (this.getCurrentWeapon() == null) {
            System.out.printf("\n%s throws a punch\n", this.getName());
            return 2;
        } else {
            if (this.getCurrentWeapon().getCategory().equals("sword")) {
                weaponBonus = 1.3;
            }
            int baseDamage = this.getCurrentWeapon().use();
            int totalDamage = (int) Math.round(this.getStrength() * weaponBonus * baseDamage);
            System.out.printf("\n%s used %s inflicting %dhp damage!\n", this.getName(), this.getCurrentWeapon().getName());
            return totalDamage;
        }
    }
}