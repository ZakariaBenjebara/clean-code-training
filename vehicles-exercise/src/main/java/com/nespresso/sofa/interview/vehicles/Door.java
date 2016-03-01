package com.nespresso.sofa.interview.vehicles;

public class Door {

    enum State {
        OPENED, CLOSED
    }

    private final int number;

    private State state = State.OPENED;

    public Door(int number) {
        this.number = number;
    }

    public void closeDoor() {
        if (state == State.OPENED)
            state = State.CLOSED;
    }

    public void emitState(final VehicleReporter reporter) {
        if (state == State.OPENED)
            reporter.emitOpenedDoor(number);
        else
            reporter.emitClosedDoor(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Door door = (Door) o;

        return number == door.number;

    }

    @Override
    public int hashCode() {
        return number;
    }
}
