package com.nespresso.sofa.interview.parking.strategy;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;
import com.nespresso.sofa.interview.parking.writer.WriterType;

public enum ParkingStrategyFactory {
    INSTANCE;

    public ParkingStrategy createParkingStrategyByBayType(final WriterType writerType, final AbstractBay bay) {
        switch (writerType) {
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
