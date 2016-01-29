package com.nespresso.sofa.interview.parking.strategy;

import com.nespresso.sofa.interview.parking.Vehicle;
import com.nespresso.sofa.interview.parking.bay.Bay;

public abstract class ParkingStrategy {

    protected final Bay bay;

    protected ParkingStrategy(Bay bay) {
        this.bay = bay;
    }

    public abstract boolean canPark(Vehicle vehicle);
}
