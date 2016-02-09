package com.nespresso.sofa.interview.parking;

import com.nespresso.sofa.interview.parking.writer.ParkingWriter;

public class Car {

    private final char vehicleType;

    public Car(char vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isForDisabledPeople() {
        return vehicleType == 'D';
    }

    public void write(final ParkingWriter writer) {
        writer.emitOccupiedNormalBay(vehicleType);
    }
}
