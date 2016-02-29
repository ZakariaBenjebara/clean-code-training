package com.nespresso.sofa.interview.vehicles;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    private final VehicleType vehicleType;

    private final Fuel fuel;

    private final List<Door> doors;

    public Vehicle(VehicleType vehicleType, Fuel fuel, int doorNumber) {
        this.vehicleType = vehicleType;
        this.fuel = fuel;
        this.doors = createDoors(doorNumber);
    }

    private List<Door> createDoors(final int doorNumber) {
        final List doors = new ArrayList();
        for (int i = 1; i <= doorNumber; i++) {
            doors.add(new Door(i));
        }
        return doors;
    }

    public String move(final int[] doorIds, final float distance) {
        final VehicleReporter reporter = new VehicleReporter();
        updateDoorSates(doorIds);
        if (doorIds.length == this.doors.size()) {
            reporter.emitDoorsOk();
            reporter.emitConsummation(vehicleType.name(), fuel.consumption(distance));
        } else {
            reporter.emitDoorsKo();
            for (final Door door : doors) {
                door.emitState(reporter);
            }
        }
        return reporter.report();
    }

    private void updateDoorSates(final int[] doorIds) {
        for (final Integer doorNumber : doorIds) {
            final Door door1 = doors.get(doorNumber - 1);
            door1.closeDoor();
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType=" + vehicleType +
                ", fuel=" + fuel +
                ", doors=" + doors +
                '}';
    }
}
