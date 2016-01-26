package com.sqli.nespresso.train.writer;

import com.sqli.nespresso.train.utils.Preconditions;
import com.sqli.nespresso.train.wagon.WagonType;

final class WriterFactory {

    public static Writable createWriter(WagonType type) {
        Preconditions.assertNotNull(type);
        switch (type) {
            case HEAD:
                return new HeadWriter();
            case PASSENGER:
                return new PassengerWriter();
            case RESTAURANT:
                return new RestaurantWriter();
            case CARGO:
                return new CargoWriter();
            default:
                throw new IllegalStateException();
        }
    }

    private WriterFactory(){}
}
