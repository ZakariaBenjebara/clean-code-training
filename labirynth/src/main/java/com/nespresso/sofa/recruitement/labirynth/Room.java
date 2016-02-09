package com.nespresso.sofa.recruitement.labirynth;

import com.nespresso.sofa.recruitement.labirynth.exception.IllegalMoveException;

import java.util.HashSet;
import java.util.Set;

public class Room {

    private final String roomId;

    private final Set<AbstractGate> gates = new HashSet<>();

    public Room(String roomId) {
        this.roomId = roomId;
    }

    public void addGate(final AbstractGate gate) {
        if (gate == null)
            throw new NullPointerException("gate == null");
        gates.add(gate);
    }

    public AbstractGate hasConnectionWith(final Room target) {
        if (target == null)
            throw new IllegalMoveException("target == null");

        for (final AbstractGate gate : gates) {
            if (gate.canWalk(target)) {
                return gate;
            }
        }
        throw new IllegalMoveException("can't reach the target");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return roomId != null ? roomId.equals(room.roomId) : room.roomId == null;

    }

    @Override
    public int hashCode() {
        return roomId != null ? roomId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return roomId;
    }
}
