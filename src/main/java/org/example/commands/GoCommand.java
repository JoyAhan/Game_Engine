package org.example.commands;

import org.example.game.GameWorld;

public class GoCommand implements Command {

    @Override
    public void execute(GameWorld gameWorld, String argument) {
        if (argument == null || argument.isBlank()) {
            System.out.println("Go where?");
            return;
        }
        if (gameWorld.moveTo(argument)) {

        } else {
            System.out.println("Can't go there");
        }
    }

}
