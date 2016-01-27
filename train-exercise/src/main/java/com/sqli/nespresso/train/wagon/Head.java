package com.sqli.nespresso.train.wagon;

public class Head extends Wagon {

    public Head(WagonType wagonType) {
        super(wagonType);
    }

    @Override
    public boolean fill() {

        return false;
    }

}
