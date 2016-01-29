package com.nespresso.sofa.interview.parking.writer;

import com.nespresso.sofa.interview.parking.bay.Bay;

import java.io.IOException;

final class DisabledWriter implements Writable {

    private final Bay bay;

    public DisabledWriter(final Bay bay) {
        this.bay = bay;
    }

    @Override
    public Appendable write(Appendable appendable) throws IOException {
        return appendable.append(bay.isAvailable() ? "@" : "D");
    }
}
