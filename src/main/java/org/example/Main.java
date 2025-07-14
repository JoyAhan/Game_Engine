package org.example;

import org.example.commands.Command;
import org.example.commands.CommandRegistry;
import org.example.game.GameWorld;
import org.example.game.WorldLoader;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/**
 * The entry class for the game engine
 */
public class Main {

    public static void main(String[] args) {


        // 3. Create the GameWorld instance
        GameWorld gameWorld = WorldLoader.loadWorld();

        // -- NEW: Command and game loop starts
        Scanner scanner = new Scanner(System.in);
        CommandRegistry commandRegistry = new CommandRegistry();

        System.out.println("Welcome to Project Odyssey!");
        System.out.println("===========================");
        displayCurrentRoom(gameWorld);

        while (true) {
            System.out.println("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = (parts.length > 1) ? parts[1] : null;

            Optional<Command> optionalCommand = commandRegistry.getCommand(command);

            if (optionalCommand.isPresent()) {
                optionalCommand.get().execute(gameWorld, argument);
                if (command.equals("go")) {
                    displayCurrentRoom(gameWorld);
                }
            } else {
                System.out.println("Unknown command: " + command);
            }

        }

    }

    public static void displayCurrentRoom(GameWorld gameWorld) {

        Room currentRoom = gameWorld.getCurrentRoom();
        System.out.println("\n--- " + currentRoom.description() + " ---");
        System.out.println(currentRoom.description());
        System.out.println("Exits: " + String.join(", ", currentRoom.exits().keySet()));

    }
}
