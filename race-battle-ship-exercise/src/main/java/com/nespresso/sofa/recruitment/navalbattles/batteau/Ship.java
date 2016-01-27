package com.nespresso.sofa.recruitment.navalbattles.batteau;

import com.nespresso.sofa.recruitment.navalbattles.race.RaceStrategy;
import com.nespresso.sofa.recruitment.navalbattles.race.RaceStrategyFactory;
import com.nespresso.sofa.recruitment.navalbattles.race.SpeedType;

import java.util.Arrays;
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
        return Arrays.asList(RaceStrategyFactory.INSTANCE.createRaceStrategyBySpeedType(SpeedType.WITH_CANNON, this));
    }
}
