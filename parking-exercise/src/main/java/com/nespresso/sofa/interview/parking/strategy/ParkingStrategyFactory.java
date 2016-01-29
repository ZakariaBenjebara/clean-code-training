package com.nespresso.sofa.interview.parking.strategy;

import com.nespresso.sofa.interview.parking.bay.Bay;
import com.nespresso.sofa.interview.parking.bay.BayType;

public enum ParkingStrategyFactory {
    INSTANCE;

    public ParkingStrategy createParkingStrategyByBayType(final BayType bayType, final Bay bay) {
        switch (bayType) {
            case NON_DISABLED:
                return new ParkingForNonDisabledPeopleStrategy(bay);
            case DISABLED:
                return new ParkingForDisabledPeopleStrategy(bay);
            case PEDESTRIAN:
                return new NullParkingStrategy(bay);
            default:
                throw new IllegalArgumentException();
        }

    }
}
