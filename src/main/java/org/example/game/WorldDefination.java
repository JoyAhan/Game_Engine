package org.example.game;

import org.example.Room;

import java.util.List;

/**
 *
 * @param startingRoomId    The room id for stating the game
 * @param rooms             The list od the rooms available in Game
 */
public record WorldDefination(String startingRoomId , List<Room> rooms) {
}
