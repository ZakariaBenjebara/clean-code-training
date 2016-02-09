package com.nespresso.sofa.interview.parking.writer;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;

import java.util.List;

public final class ParkingPrinter {

    private ParkingPrinter() {}

    public static String printBays(final List<AbstractBay> bays) {
        final int dimension = (int) Math.sqrt(bays.size());
        final ParkingWriter writer = new ParkingWriter(dimension);
        for (final AbstractBay bay : bays) {
            bay.write(writer);
        }
        return writer.build().toString();
    }
}
