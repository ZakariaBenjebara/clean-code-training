package com.nespresso.sofa.recruitment.navalbattles.race;

import com.nespresso.sofa.recruitment.navalbattles.batteau.AbstractShip;

public enum RaceStrategyFactory {
    INSTANCE;

    public RaceStrategy createRaceStategyBySpeedType(final SpeedType speedType, final AbstractShip ship) {
        if (speedType == null) {
            throw new NullPointerException("Missing the speed type value");
        }
        switch (speedType) {
            case CLIPPER:
                return new ClipperRaceStrategy(ship);
            default:
                throw new IllegalStateException();
        }
    }
}
