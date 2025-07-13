package org.example.commands;

import org.example.game.GameWorld;



public interface Command {
    /**
       * Execute the command
     * @param  gameWorld
     */
    void execute(GameWorld gameWorld , String argument)
}
