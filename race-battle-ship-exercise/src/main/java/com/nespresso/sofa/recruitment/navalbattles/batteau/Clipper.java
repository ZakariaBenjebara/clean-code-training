package com.nespresso.sofa.recruitment.navalbattles.batteau;

import com.nespresso.sofa.recruitment.navalbattles.race.RaceStrategy;
import com.nespresso.sofa.recruitment.navalbattles.race.RaceStrategyFactory;
import com.nespresso.sofa.recruitment.navalbattles.race.SpeedType;

import java.util.Arrays;
import java.util.List;

public class Clipper extends AbstractShip {

    public Clipper(int displacement, int mast) {
        super(displacement, mast);
    }

    public Clipper(int displacement, int mast, int canonNumber) {
        super(displacement, mast, canonNumber);
    }

    @Override
    protected List<RaceStrategy> raceStrategies() {
        return Arrays.asList(RaceStrategyFactory.INSTANCE.createRaceStategyBySpeedType(SpeedType.CLIPPER, this));
    }
}
