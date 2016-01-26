package com.sqli.nespresso.train.wagon;


public abstract class Wagon {

    private final WagonType wagonType;

    public Wagon(WagonType wagonType) {
        this.wagonType = wagonType;
    }

    public abstract boolean fill();

    public WagonType getWagonType() {
        return wagonType;
    }

    public boolean isHead() {
        return WagonType.isHead(wagonType);
    }
}
