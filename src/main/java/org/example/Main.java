package org.example;

import org.example.game.GameWorld;

import java.util.Map;
import java.util.Scanner;

/**
 *  The entry class for the game engine
 */
public class Main {

    public static void  main(String[] args) {
        // 1. Create the rooms
        Room entryHall = new Room(
                "entry-hall",
                "The Grand Entry Hall",
                "You are in a vast, dusty hall. A single wooden door lies to the NORTH.",
                Map.of("NORTH", "library") // Java 9+ Map.of for immutable maps
        );

        Room library = new Room(
                "library",
                "The Dusty Library",
                "You've entered a library filled with ancient, leather-bound books. The exit is to the SOUTH.",
                Map.of("SOUTH", "entry-hall")
        );

        Map<String , Room>  worldRooms = Map.of(
                entryHall.id() ,  entryHall,
                library.id(), library
        );

        // 3. Create the GameWorld instance
        GameWorld gameWorld = new GameWorld(worldRooms, "entry-hall");

        Scanner scanner = new Scanner(System.in);
        boolean isGameRunning = true;


        //Initial room description
        displayCurrentRoom(gameWorld);
        
        while(isGameRunning) {
            System.out.println("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            String[] parts = input.split(" ",2);
            String command = parts[0];
            String argument = (parts.length > 1) ? parts[1] : null;

            switch (command) {
                case "go":
                    if (argument == null) {
                        System.out.println("Go where?");
                    } else {
                        if (gameWorld.moveTo(argument)) {
                            displayCurrentRoom(gameWorld);
                        } else {
                            System.out.println("You can't go that way.");
                        }
                    }
                    break;
                case "look":
                    displayCurrentRoom(gameWorld);
                    break;
                case "quit":
                    isGameRunning = false;
                    System.out.println("Thank you for playing!");
                    break;
                case "help":
                    System.out.println("Available commands: go [direction], look, quit");
                    break;
                default:
                    System.out.println("I don't understand that command.");
                    break;
            }
        }

        scanner.close();

    }

    public static void displayCurrentRoom(GameWorld gameWorld) {

        Room currentRoom = gameWorld.getCurrentRoom();
        System.out.println("\n--- " + currentRoom.description() + " ---");
        System.out.println(currentRoom.description());
        System.out.println("Exits: " + String.join(", ", currentRoom.exits().keySet()));

    }
}
