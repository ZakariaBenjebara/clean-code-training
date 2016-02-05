package com.nespresso.sofa.interview.parking.writer;

import java.io.IOException;

final class VehicleWriter implements Writable {

    private final char representation;

    public VehicleWriter(char representation) {
        this.representation = representation;
    }

    @Override
    public Appendable write(Appendable appendable) throws IOException {
        return appendable.append(String.valueOf(representation));
    }
}
