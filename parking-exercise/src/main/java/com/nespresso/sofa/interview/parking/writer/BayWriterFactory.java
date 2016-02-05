package com.nespresso.sofa.interview.parking.writer;

public enum BayWriterFactory {
    INSTANCE;

    public <T> Writable createWriter(final WriterType writerType, T t) {
        switch (writerType) {
            case NON_DISABLED:
                return new NonDisabledWriter();
            case DISABLED:
                return new DisabledWriter();
            case DISABLED_AND_OCCUPIED:
                return new OccupiedDisabledWriter();
            case PEDESTRIAN:
                return new PedestrianWriter();
            case OCCUPIED:
                return new VehicleWriter((Character) t);
            default:
                throw new IllegalArgumentException();
        }
    }
}
