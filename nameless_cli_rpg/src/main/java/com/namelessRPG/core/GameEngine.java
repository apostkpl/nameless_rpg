package com.namelessRPG.core;
import java.util.Scanner;
import com.namelessRPG.character.Player;
import com.namelessRPG.character.Warrior;


public class GameEngine {
    private Player player;
    private Scanner scanner;

    // Constructor
    public GameEngine() {
        this.scanner = new Scanner(System.in);
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