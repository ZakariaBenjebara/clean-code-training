package com.sqli.nespresso.train.wagon;

public class Passenger extends Wagon {

    public Passenger(WagonType wagonType) {
        super(wagonType);
    }

    @Override
    public boolean fill() {
        return false;
    }
}
