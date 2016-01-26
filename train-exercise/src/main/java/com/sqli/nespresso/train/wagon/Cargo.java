package com.sqli.nespresso.train.wagon;

import com.sqli.nespresso.train.state.CargoState;

public class Cargo extends Wagon {

    private CargoState cargoState = new CargoState();

    public Cargo(WagonType wagonType) {
        super(wagonType);
    }

    public boolean isEmptyCargo() {
        return cargoState.isEmpty();
    }

    @Override
    public boolean fill() {
        return cargoState.change();
    }
}

