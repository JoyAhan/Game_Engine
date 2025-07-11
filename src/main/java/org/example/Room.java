package org.example;


import java.util.Map;


/**
 * Represents  a single location in the game world
 * @param id            A unique machine-readable identifier for the room
 * @param name          A human-readable name for the room
 * @param description   Text shown to the player upon entering the room
 * @param exits         A map where key is the direction and value
 *                      is the identifier of the room
 */

public record Room(String id , String name , String description , Map<String,String> exits) {
}
