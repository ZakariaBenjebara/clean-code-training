package com.nespresso.sofa.interview.parking.strategy;

import com.nespresso.sofa.interview.parking.Vehicle;
import com.nespresso.sofa.interview.parking.bay.Bay;

final class ParkingForNonDisabledPeopleStrategy extends ParkingStrategy {

    public ParkingForNonDisabledPeopleStrategy(Bay bay) {
        super(bay);
    }

    @Override
    public boolean canPark(final Vehicle vehicle) {
        return !vehicle.isForDisabledPeople() && bay.isAvailable();
    }
}
