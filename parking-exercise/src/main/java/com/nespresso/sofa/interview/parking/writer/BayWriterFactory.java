package com.nespresso.sofa.interview.parking.writer;

import com.nespresso.sofa.interview.parking.Vehicle;
import com.nespresso.sofa.interview.parking.bay.Bay;
import com.nespresso.sofa.interview.parking.bay.BayType;

public enum BayWriterFactory {
    INSTANCE;

    public <T> Writable createWriter(final BayType bayType, final T type) {
        switch (bayType) {
            case NON_DISABLED:
                return new NonDisabledWriter();
            case DISABLED:
                return new DisabledWriter((Bay) type);
            case PEDESTRIAN:
                return new PredetrianWriter();
            case OCCUPIED:
                return new VehicleWriter((Vehicle) type);
            default:
                throw new IllegalArgumentException();
        }
    }
}
