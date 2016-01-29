package com.nespresso.sofa.interview.parking.writer;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;

import java.io.IOException;

final class DisabledWriter implements Writable {

    private final AbstractBay bay;

    public DisabledWriter(final AbstractBay bay) {
        this.bay = bay;
    }

    @Override
    public Appendable write(Appendable appendable) throws IOException {
        return appendable.append(bay.isAvailable() ? "@" : "D");
    }
}
