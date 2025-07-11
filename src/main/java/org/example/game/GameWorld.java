package org.example.game;

import org.example.Room;

import java.util.Map;

/**
 *  Represent the main controller to manage all the rooms in the game
 */

public class GameWorld {
    private final Map<String , Room> rooms;
    private String currentRoomId;

    public GameWorld(Map<String, Room> rooms , String currentRoomId) {
        this.rooms = rooms;
        this.currentRoomId = currentRoomId;
    }

    public Room getCurrentRoom() {
        return rooms.get(currentRoomId);
    }
}
