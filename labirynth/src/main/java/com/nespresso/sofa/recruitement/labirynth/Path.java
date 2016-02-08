package com.nespresso.sofa.recruitement.labirynth;

import java.util.ArrayDeque;
import java.util.Deque;

public class Path {

    private Room currentRoom;

    private final Deque<AbstractGate> passedDoors = new ArrayDeque<>();

    public Path(Room currentRoom) {
        if (currentRoom == null) {
            new NullPointerException("room == null");
        }
        this.currentRoom = currentRoom;
    }

    public void walkTo(final Room target) {
        AbstractGate passedDoor = currentRoom.hasConnectionWith(target);
        if (passedDoor != null) {
            currentRoom = target;
            passedDoors.add(passedDoor);
        }
    }

    public void closeLastDoor() {
        passedDoors.getLast().close();
    }

    public String readSensors() {
        return WalkerFollower.readSensors(passedDoors);
    }
}
