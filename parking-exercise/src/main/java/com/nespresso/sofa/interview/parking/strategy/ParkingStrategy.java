package com.nespresso.sofa.interview.parking.strategy;

import com.nespresso.sofa.interview.parking.Vehicle;
import com.nespresso.sofa.interview.parking.bay.AbstractBay;

public abstract class ParkingStrategy {

    protected final AbstractBay bay;

    protected ParkingStrategy(AbstractBay bay) {
        this.bay = bay;
    }

    public abstract boolean canPark(Vehicle vehicle);
}
