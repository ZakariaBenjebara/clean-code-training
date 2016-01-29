package com.nespresso.sofa.interview.parking.bay;

import com.nespresso.sofa.interview.parking.Vehicle;
import com.nespresso.sofa.interview.parking.writer.Writable;

public abstract class AbstractBay implements Comparable<AbstractBay> {

    protected final int bayNumber;

    protected int exitDistance = Integer.MAX_VALUE;

    public AbstractBay(int bayNumber) {
        this.bayNumber = bayNumber;
    }

    public abstract boolean isAvailable();

    public abstract boolean canPark(final Vehicle vehicle);

    public abstract int park(final Vehicle vehicle);

    public abstract boolean unpark();

    public abstract Writable createWriter();

    public boolean equalsNumber(final int number) {
        return this.bayNumber == number;
    }

    @Override
    public int compareTo(final AbstractBay o2) {
        if (this.exitDistance > o2.exitDistance)
            return 1;
        else if (this.exitDistance < o2.exitDistance)
            return -1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractBay bay = (AbstractBay) o;

        if (bayNumber != bay.bayNumber) return false;
        return exitDistance == bay.exitDistance;

    }

    @Override
    public int hashCode() {
        int result = bayNumber;
        result = 31 * result + exitDistance;
        return result;
    }

    @Override
    public String toString() {
        return "AbstractBay{" +
                "bayNumber=" + bayNumber +
                ", exitDistance=" + exitDistance +
                '}';
    }
}
