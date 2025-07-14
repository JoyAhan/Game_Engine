package org.example.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Room;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WorldLoader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static GameWorld loadWorld() {
        String worldFileName = "/world.json";
        try( InputStream inputStream = WorldLoader.class.getResourceAsStream(worldFileName) ) {
            if (inputStream == null) {
                System.out.println("World file with name " + worldFileName +" not found");
            }
            WorldDefination def = objectMapper.readValue(inputStream, WorldDefination.class);
            Map<String,Room> roomsMap = def.rooms().stream().collect(Collectors.toMap(Room::id, Function.identity()));
            return new GameWorld(roomsMap , def.startingRoomId());
        } catch (IOException e) {
            System.out.println("Error");
            System.exit(1);
            return null;
        }
    }


}
