package org.example.commands;

import java.util.Set;

import org.example.game.GameWorld;

public class HelpCommand implements Command {

    private final Set<String> availableCommands;

    public HelpCommand(Set<String> availableCommands) {
        this.availableCommands = availableCommands;
    }

    @Override
    public void execute(GameWorld gameWorld, String argument) {
        System.out.println("Available Commands are:" + String.join(", ", availableCommands));
    }

}
