package com.nespresso.sofa.recruitement.labirynth;

public class SensorGate extends AbstractGate {

    private int passedNumber = 0;

    public SensorGate(Room room1, Room room2) {
        super(room1, room2);
    }

    public void passed() {
        synchronized (this) {
            passedNumber++;
        }
    }

    public String print() {
        return room1.toString()+room2.toString();
    }
}
