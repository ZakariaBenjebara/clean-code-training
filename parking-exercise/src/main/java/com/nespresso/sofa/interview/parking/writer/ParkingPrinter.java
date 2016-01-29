package com.nespresso.sofa.interview.parking.writer;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;

import java.io.IOException;
import java.util.List;

public final class ParkingPrinter {

    private ParkingPrinter() {
    }

    public static String printBays(final List<AbstractBay> bays) throws IOException {
        final StringBuilder builder = new StringBuilder();
        StringBuilder builderPart = new StringBuilder();
        final int dimension = (int) Math.sqrt(bays.size());
        int dimensionCounter = 0;
        int currentDimension = 1;
        for (final AbstractBay bay : bays) {
            bay.createWriter().write(builderPart);
            dimensionCounter++;
            if (dimensionCounter == dimension) {
                if (currentDimension % 2 != 0) {
                    builder.append(builderPart);
                } else {
                    builder.append(builderPart.reverse());
                }
                builder.append("\n");
                dimensionCounter = 0;
                currentDimension++;
                builderPart = new StringBuilder();
            }
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
