package com.sqli.nespresso.train.factory;

import com.sqli.nespresso.train.wagon.*;
import com.sqli.nespresso.train.utils.Preconditions;

public enum WagonFactory {
    INSTANCE;

    public Wagon createWagon(WagonType type) {
        Preconditions.assertNotNull(type);
        switch (type) {
            case HEAD:
                return new Head(type);
            case PASSENGER:
                return new Passenger(type);
            case RESTAURANT:
                return new Restaurant(type);
            case CARGO:
                return new Cargo(type);
            default:
                throw new IllegalStateException();
        }
    }
}
