package org.example.game;

import org.example.Room;

import java.util.Map;
import java.util.Optional;

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

    public boolean moveTo(String direction) {
        Room currentRoom = getCurrentRoom();

        Optional<String> nextRoomIdOpt = Optional.ofNullable(currentRoom.exits().get(direction.toUpperCase()));


        if(nextRoomIdOpt.isPresent()){
                String nextRoomId = nextRoomIdOpt.get();
                if(rooms.containsKey(nextRoomId)) {
                    this.currentRoomId = nextRoomId;
                    return true;
                }
        };

        return false;
    }
}
