package com.nespresso.sofa.recruitment.navalbattles.race;

import com.nespresso.sofa.recruitment.navalbattles.batteau.AbstractShip;

public enum RaceStrategyFactory {
    INSTANCE;

    public RaceStrategy createRaceStrategyBySpeedType(final SpeedType speedType, final AbstractShip ship) {
        if (speedType == null) {
            throw new NullPointerException("Missing the adaptSpeed type value");
        }
        switch (speedType) {
            case CLIPPER:
                return new ClipperRaceStrategy(ship);
            case WITH_CANON:
                return new WithCanonsRaceStrategy(ship);
            default:
                throw new IllegalStateException();
        }
    }
}
