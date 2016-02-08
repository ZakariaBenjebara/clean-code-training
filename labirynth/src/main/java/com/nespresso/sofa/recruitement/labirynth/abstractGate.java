package com.nespresso.sofa.recruitement.labirynth;

import com.nespresso.sofa.recruitement.labirynth.exception.ClosedDoorException;
import com.nespresso.sofa.recruitement.labirynth.exception.DoorAlreadyClosedException;

public abstract class AbstractGate {

    protected final Room room1;

    protected final Room room2;

    private boolean opened = true;

    public AbstractGate(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    public boolean canWalk(final Room target) {
        if (!opened)
            throw new ClosedDoorException("");
        if (target.equals(room1) || target.equals(room2)) {
            return true;
        }
        return false;
    }

    public void close() {
        if (!opened)
            throw new DoorAlreadyClosedException("already closed");

        opened = false;
    }
}
