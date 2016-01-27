package com.nespresso.sofa.recruitment.navalbattles.batteau;

public abstract class AbstractShip {

    private final int displacement;

    private final int mast;

    private final int canonNumber;

    public AbstractShip(int displacement, int mast) {
        this.displacement = displacement;
        this.mast = mast;
        this.canonNumber = 0;
    }

    public AbstractShip(int displacement, int mast, int canonNumber) {
        this.displacement = displacement;
        this.mast = mast;
        this.canonNumber = canonNumber;
    }

    public double speed() {
        if (mast == 0) {
            throw new IllegalStateException();
        }
        return displacement / mast;
    }
}
