package com.nespresso.sofa.interview.parking.writer;

public final class ParkingWriter {

    private final StringBuilder out = new StringBuilder();

    private final int dimension;

    private StringBuilder part = new StringBuilder();

    private int currentDim = 1;

    private int counterDim = 0;

    public ParkingWriter(int dimension) {
        this.dimension = dimension;
    }

    public void emitEmptyNormalBay() {
        part.append("U");
        adapt();
    }

    public void emitPedestrianExit() {
        part.append("=");
        adapt();
    }

    public void emitEmptyDisabledBay() {
        part.append("@");
        adapt();
    }

    public void emitOccupiedDisabledBay() {
        part.append("D");
        adapt();
    }

    public void emitOccupiedNormalBay(final char carType) {
        part.append(carType);
        adapt();
    }

    public StringBuilder build() {
        return out.deleteCharAt(out.length() - 1);
    }

    private void adapt() {
        counterDim++;
        if (counterDim == dimension) {
            if (currentDim % 2 != 0) {
                out.append(part);
            } else {
                out.append(part.reverse());
            }
            out.append("\n");
            counterDim = 0;
            currentDim++;
            part = new StringBuilder();
        }
    }
}
