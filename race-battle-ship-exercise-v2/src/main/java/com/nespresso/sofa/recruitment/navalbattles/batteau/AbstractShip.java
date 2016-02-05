package com.nespresso.sofa.recruitment.navalbattles.batteau;

public abstract class AbstractShip implements Comparable<AbstractShip> {

    final int displacement;

    final int mast;

    public AbstractShip(int displacement, int mast) {
        this.displacement = displacement;
        this.mast = mast;
    }

    protected final double baseSpeed() {
        if (mast <= 0) {
            throw new IllegalStateException("The mast must be superior than zero!");
        }
        return displacement / mast;
    }

    @Override
    public int compareTo(final AbstractShip that) {
        if (this.speed() < that.speed())
            return -1;
        else if (this.speed() > that.speed())
            return 1;
        return 0;
    }

    protected abstract double speed();

    @Override
    public String toString() {
        return "AbstractShip{" +
                "displacement=" + displacement +
                ", mast=" + mast +
                '}';
    }
}
