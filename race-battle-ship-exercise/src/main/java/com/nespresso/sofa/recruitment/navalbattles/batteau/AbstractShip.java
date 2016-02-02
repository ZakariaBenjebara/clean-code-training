package com.nespresso.sofa.recruitment.navalbattles.batteau;

import com.nespresso.sofa.recruitment.navalbattles.race.RaceStrategy;

import java.util.List;

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
        double speed = baseSpeed();
        for (final RaceStrategy raceStrategy : raceStrategies()) {
            speed = raceStrategy.adaptSpeed(speed);
        }
        return speed;
    }

    protected final double baseSpeed() {
        if (mast == 0) {
            throw new IllegalStateException();
        }
        return displacement / mast;
    }

    public int numberOfCanons() {
        return canonNumber;
    }

    protected abstract List<RaceStrategy> raceStrategies();
}
