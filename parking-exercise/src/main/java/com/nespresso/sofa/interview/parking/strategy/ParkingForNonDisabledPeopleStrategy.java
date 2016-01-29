package com.nespresso.sofa.interview.parking.strategy;

import com.nespresso.sofa.interview.parking.Vehicle;
import com.nespresso.sofa.interview.parking.bay.AbstractBay;

final class ParkingForNonDisabledPeopleStrategy extends ParkingStrategy {

    public ParkingForNonDisabledPeopleStrategy(AbstractBay bay) {
        super(bay);
    }

    @Override
    public boolean canPark(final Vehicle vehicle) {
        return !vehicle.isForDisabledPeople() && bay.isAvailable();
    }
}
