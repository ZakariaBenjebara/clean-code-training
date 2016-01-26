package com.sqli.nespresso.train.writer;

import com.sqli.nespresso.train.wagon.Passenger;

final class PassengerWriter extends WagonWriterTemplate<Passenger, String> {

    @Override
    protected String shape(final Passenger passenger) {
        return "|OOOO|";
    }
}
