package org.example.commands;

import org.example.Main;
import org.example.game.GameWorld;

public class LookCommand implements Command {

    @Override
    public void execute(GameWorld gameWorld, String argument) {
        Main.displayCurrentRoom(gameWorld);
    }

}
