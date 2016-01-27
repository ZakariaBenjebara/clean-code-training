package com.nespresso.sofa.recruitment.navalbattles.race;

import com.nespresso.sofa.recruitment.navalbattles.batteau.AbstractShip;

final class ClipperRaceStrategy extends RaceStrategy {

    private static final double SPEED_PERCENTAGE = 0.2;

    public ClipperRaceStrategy(AbstractShip ship) {
        super(ship);
    }

    @Override
    public double adaptSpeed(double baseSpeed) {
        return baseSpeed - (baseSpeed * SPEED_PERCENTAGE);
    }
}
