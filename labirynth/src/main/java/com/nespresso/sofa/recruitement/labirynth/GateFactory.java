package com.nespresso.sofa.recruitement.labirynth;

public enum  GateFactory {
    INSTANCE;

    public AbstractGate createGate(final char representation, final Room room1, final Room room2) {
        if (room1 == null)
            throw new NullPointerException("room1 == null");
        if (room2 == null)
            throw new NullPointerException("room2 == null");

        switch (representation) {
            case '|':
                return new Gate(room1, room2);
            case '$':
                return new SensorGate(room1, room2);
            default:
                throw new IllegalArgumentException("Unknown type of gate");
        }
    }
}
