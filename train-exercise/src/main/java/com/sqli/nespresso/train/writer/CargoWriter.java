package com.sqli.nespresso.train.writer;

import com.sqli.nespresso.train.wagon.Cargo;

final class CargoWriter extends WagonWriterTemplate<Cargo, String> {

    @Override
    protected String shape(final Cargo cargo) {
        return cargo.isEmptyCargo() ? "|____|" : "|^^^^|";
    }
}
