package com.sqli.nespresso.train.writer;

import com.sqli.nespresso.train.wagon.Wagon;
import com.sqli.nespresso.train.wagon.WagonType;

import java.io.IOException;
import java.util.List;

public final class WagonPrinter {

    public static String printWagons(final List<Wagon> wagons) throws IOException {
        if (wagons == null || wagons.isEmpty()) {
            throw new IllegalArgumentException("Missing wagon!");
        }
        final StringBuilder printBuilder = new StringBuilder();
        for (int i = 0; i < wagons.size(); i++) {
            final Wagon wagon = wagons.get(i);
            final boolean first = (i == 0);
            final boolean last = (i == wagons.size() - 1);

            final WagonContext wagonContext = new WagonContext(wagon, first, last);

            printWagon(wagonContext, printBuilder);
        }
        return printBuilder.toString();
    }

    private static void printWagon(final WagonContext wagonContext, final StringBuilder printBuilder) throws IOException {
        if (wagonContext == null) {
            throw new IllegalArgumentException("Missing wagon context!");
        }
        final Wagon wagon = wagonContext.wagon;
        final WagonType wagonType = wagon.getWagonType();
        WriterFactory.createWriter(wagonType).write(printBuilder, wagonContext);
    }

    private static final class WagonContext implements Writable.Context<Wagon, String> {

        private final Wagon wagon;

        private final boolean isFirstWagon;

        private final boolean isLastWagon;

        public WagonContext(Wagon wagon, boolean isFirstWagon, boolean isLastWagon) {
            this.wagon = wagon;
            this.isFirstWagon = isFirstWagon;
            this.isLastWagon = isLastWagon;
        }

        @Override
        public Wagon get() {
            return wagon;
        }

        @Override
        public String leftBounds() {
            return isFirstWagon ? (wagon.isHead() ? "<" : "") : ":";
        }

        @Override
        public String rightBounds() {
            return isLastWagon ? (wagon.isHead() ? ">" : "") : ":";
        }
    }

    private WagonPrinter() {
    } // private constructor
}
