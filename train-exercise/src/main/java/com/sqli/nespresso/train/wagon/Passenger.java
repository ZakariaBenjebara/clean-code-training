package com.sqli.nespresso.train.wagon;

public class Passenger extends Wagon {

    private final String json = "{\"name\": \"zakaria\"}";

    public Passenger(WagonType wagonType) {
        super(wagonType);
    }

    @Override
    public boolean fill() {
        return false;
    }
}
