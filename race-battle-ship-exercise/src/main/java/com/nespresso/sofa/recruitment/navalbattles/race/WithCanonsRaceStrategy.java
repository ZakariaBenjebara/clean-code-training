package com.nespresso.sofa.recruitment.navalbattles.race;

import com.nespresso.sofa.recruitment.navalbattles.batteau.AbstractShip;

final class WithCanonsRaceStrategy extends RaceStrategy {

    private static final double CANON_SPEED_PENALTY = 0.005;

    public WithCanonsRaceStrategy(final AbstractShip ship) {
        super(ship);
    }

    @Override
    public double adaptSpeed(final double baseSpeed) {
        double adaptedSpeed = baseSpeed;
        for (int i = 1; i <= ship.numberOfCanons(); i++) {
            adaptedSpeed += adaptedSpeed * CANON_SPEED_PENALTY;
        }
        return adaptedSpeed;
    }
}
