package com.sqli.nespresso.train.wagon;

public class Restaurant extends Wagon {

    public Restaurant(WagonType wagonType) {
        super(wagonType);
    }

    @Override
    public boolean fill() {
       return false;
    }
}
