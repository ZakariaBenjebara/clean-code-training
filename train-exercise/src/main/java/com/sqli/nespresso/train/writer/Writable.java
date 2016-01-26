package com.sqli.nespresso.train.writer;

import java.io.IOException;

public interface Writable<T, W> {

    interface Context<T, W> {
        T get();
        W leftBounds();
        W rightBounds();
    }

    void write(Appendable appendable, Context<T, W> context) throws IOException;
}
