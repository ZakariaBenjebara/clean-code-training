package com.sqli.nespresso.train.writer;

import com.sqli.nespresso.train.utils.Preconditions;
import com.sqli.nespresso.train.wagon.Wagon;

import java.io.IOException;

abstract class WagonWriterTemplate<T extends Wagon, w extends CharSequence> implements Writable<T, w> {

    @Override
    public void write(final Appendable appendable, final Context<T, w> context) throws IOException {
        Preconditions.assertNotNull(context);
        Preconditions.assertNotNull(appendable);

        appendable.append(context.leftBounds())
                .append(shape(context.get()))
                .append(context.rightBounds());
    }

    protected abstract w shape(T wagon);
}
