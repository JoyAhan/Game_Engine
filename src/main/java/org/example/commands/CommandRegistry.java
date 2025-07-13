package org.example.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandRegistry {

    private final Map<String, Command> commandList = new HashMap<>();

    public CommandRegistry() {
        commandList.put("go", new GoCommand());
        commandList.put("look", new LookCommand());
        commandList.put("help", new HelpCommand(commandList.keySet()));
        commandList.put("quit", (gameWorld, argument) -> {
            System.out.println("Thanks for playing. Bye.");
            System.exit(0);
        });
    }

    public Optional<Command> getCommand(String commandName) {
        return Optional.ofNullable(commandList.get(commandName));
    }

}
