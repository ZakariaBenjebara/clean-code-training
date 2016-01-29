package com.nespresso.sofa.interview.parking.writer;

import java.io.IOException;

public interface Writable {
    Appendable write(Appendable appendable) throws IOException;
}
