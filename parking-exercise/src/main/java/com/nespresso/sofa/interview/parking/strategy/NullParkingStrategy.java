package com.nespresso.sofa.interview.parking.strategy;

import com.nespresso.sofa.interview.parking.bay.Bay;
import com.nespresso.sofa.interview.parking.Vehicle;

final class NullParkingStrategy extends ParkingStrategy {

    public NullParkingStrategy(Bay bay) {
        super(bay);
    }

    @Override
    public boolean canPark(final Vehicle vehicle) {
        return false;
    }
}
