package com.nespresso.sofa.interview.parking.writer;

import java.io.IOException;

final class NonDisabledWriter implements Writable {

    @Override
    public Appendable write(Appendable appendable) throws IOException {
        return appendable.append("U");
    }
}
