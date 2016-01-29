package com.nespresso.sofa.interview.parking.strategy;

import com.nespresso.sofa.interview.parking.bay.Bay;
import com.nespresso.sofa.interview.parking.Vehicle;

final class ParkingForDisabledPeopleStrategy extends ParkingStrategy {

    public ParkingForDisabledPeopleStrategy(Bay bay) {
        super(bay);
    }

    @Override
    public boolean canPark(final Vehicle vehicle) {
        return vehicle.isForDisabledPeople() && bay.isAvailable();
    }
}
