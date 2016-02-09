package com.nespresso.sofa.recruitement.labirynth;

import java.util.Map;

public class Labyrinth {

    private final Map<String, Room> rooms;

    private Path path;

    public Labyrinth(String... rooms) {
        if (rooms == null) {
            throw new IllegalArgumentException();
        }
        LabyrinthBuilder builder = new LabyrinthBuilder();
        for (String connection : rooms) {
            builder.appendConnection(connection);
        }
        this.rooms = builder.build();
    }

    public void popIn(final String roomId) {
        if (roomId == null) {
            throw new IllegalArgumentException("Missing the room id");
        }
        final Room currentRoom = rooms.get(roomId);
        path = new Path(currentRoom);
    }

    public void walkTo(final String roomId) {
        if (roomId == null) {
            throw new NullPointerException();
        }
        final Room target = rooms.get(roomId);
        path.walkTo(target);
    }

    public void closeLastDoor() {
        path.closeLastDoor();
    }

    public String readSensors() {
        return path.readSensors();
    }
}
