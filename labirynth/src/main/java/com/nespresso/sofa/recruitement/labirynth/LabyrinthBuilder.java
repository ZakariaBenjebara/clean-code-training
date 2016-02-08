package com.nespresso.sofa.recruitement.labirynth;

import java.util.HashMap;
import java.util.Map;

public final class LabyrinthBuilder {

    private final Map<String, Room> rooms = new HashMap<>();

    public LabyrinthBuilder() {}

    public LabyrinthBuilder appendConnection(final String connection) {
        final String idOfRoom1 = String.valueOf(connection.charAt(0));
        final String idOfRoom2 = String.valueOf(connection.charAt(2));
        final Room room1 = findOrCreate(idOfRoom1);
        final Room room2 = findOrCreate(idOfRoom2);
        final AbstractGate gate = GateFactory.INSTANCE.createGate(connection.charAt(1), room1, room2);
        room1.addGate(gate);
        room2.addGate(gate);
        rooms.put(idOfRoom1, room1);
        rooms.put(idOfRoom2, room2);
        return this;
    }

    private Room findOrCreate(final String idOfRoom) {
        if (rooms.containsKey(idOfRoom))
            return rooms.get(idOfRoom);

        return new Room(idOfRoom);
    }

    public Map<String, Room> build() {
        return rooms;
    }
}
