package com.namelessRPG.character;

public class Sorcerer extends Player {
    private double strength;
    private double charisma;

    // Constructor
    public Sorcerer(String name) {
        super(name, 100);
        this.strength = 1.0;
        this.charisma = 1.2;
    }

    // Getter for strength (which doesn't exist in the parent class)
    public double getStrength() {
        return this.strength;
    }
    // Getter for charisma (also not in the parent class)
    public double getCharisma() {
        return this.charisma;
    }

    // Level up for charisma
    public boolean levelUpCharisma(double percent) {
        if (percent <= 0 || percent > 1) {
            System.out.printf("\nError leveling up %s, the leveling up must be proportional. Please rport back.\n", this.getName());
            return false;
        } else {
            this.charisma += this.charisma * percent;
            System.out.printf("\nYour warrior leveled up. Their strength is now %.2f.", this.getCharisma());
            return true;
        }
    }

    // Override the abstract attack method
    @Override
    public int attack() {
        if (this.getCurrentWeapon() == null) {
            System.out.printf("\n%s throws a punch\n", this.getName());
            return 2;
        } else {
            int baseDamage = this.getCurrentWeapon().use();
            int totalDamage = (int) Math.round(this.getStrength() * baseDamage);
            System.out.printf("\n%s used %s inflicting %dhp damage!\n", this.getName(), this.getCurrentWeapon().getName());
            return totalDamage;
        }
    }

    // Sorcerer specific method:
    public int castFireball() {
        return (int) Math.round(this.getCharisma() * 5);
    }
}