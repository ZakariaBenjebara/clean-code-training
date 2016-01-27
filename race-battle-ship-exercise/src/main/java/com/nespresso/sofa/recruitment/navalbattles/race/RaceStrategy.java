package com.nespresso.sofa.recruitment.navalbattles.race;

import com.nespresso.sofa.recruitment.navalbattles.batteau.AbstractShip;

public abstract class RaceStrategy {

    protected final AbstractShip ship;

    public RaceStrategy(AbstractShip ship) {
        this.ship = ship;
    }

    public abstract double adaptSpeed(double baseSpeed);

}
