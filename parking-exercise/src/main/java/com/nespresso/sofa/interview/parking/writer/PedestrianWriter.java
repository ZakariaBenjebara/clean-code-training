package com.nespresso.sofa.interview.parking.writer;

import java.io.IOException;

final class PedestrianWriter implements Writable {

    @Override
    public Appendable write(final Appendable appendable) throws IOException {
        return appendable.append("=");
    }
}
