package com.nespresso.sofa.interview.parking.bay;

import com.nespresso.sofa.interview.parking.writer.ParkingWriter;

public abstract class AbstractBay implements Comparable<AbstractBay> {

    protected final int number;

    protected int exitDistance = Integer.MAX_VALUE;

    public AbstractBay(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(final AbstractBay that) {
        if (this.exitDistance < that.exitDistance)
            return -1;
        else if (this.exitDistance > that.exitDistance)
            return 1;
        return 0;
    }

    public abstract boolean isAvailable();

    public abstract void write(ParkingWriter writer);
}
