package com.nespresso.sofa.interview.parking.writer;

import com.nespresso.sofa.interview.parking.Vehicle;

import java.io.IOException;

final class VehicleWriter implements Writable {

    private final Vehicle vehicle;

    public VehicleWriter(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public Appendable write(Appendable appendable) throws IOException {
        return appendable.append(vehicle.toString());
    }
}
