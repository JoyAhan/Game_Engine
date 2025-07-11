package org.example;

import org.example.game.GameWorld;

import java.util.Map;

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

        // 4. Simple Game Loop (for now)
        System.out.println("Welcome to Project Odyssey!");
        System.out.println("===========================");

        // Print the description of the starting room
        Room currentRoom = gameWorld.getCurrentRoom();
        System.out.println(currentRoom.name());
        System.out.println(currentRoom.description());
    }
}
