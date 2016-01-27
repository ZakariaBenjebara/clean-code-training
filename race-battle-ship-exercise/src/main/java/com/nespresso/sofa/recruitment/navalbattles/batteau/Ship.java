package com.nespresso.sofa.recruitment.navalbattles.batteau;

import com.nespresso.sofa.recruitment.navalbattles.race.RaceStrategy;

import java.util.Collections;
import java.util.List;

public class Ship extends AbstractShip {

    public Ship(int displacement, int mast) {
        super(displacement, mast);
    }

    public Ship(int displacement, int mast, int canonNumber) {
        super(displacement, mast, canonNumber);
    }

    @Override
    protected List<RaceStrategy> raceStrategies() {
        return Collections.emptyList();
    }
}
