package org.example.commands;

import org.example.game.GameWorld;



public interface Command {
    /**
       * Execute the command
     * @param  gameWorld The current state of the game world
     * @param  argument The argument provided by the player
     */
    void execute(GameWorld gameWorld , String argument);
}
