package com.nespresso.sofa.recruitment.navalbattles.batteau;

import com.nespresso.sofa.recruitment.navalbattles.battle.Defender;
import com.nespresso.sofa.recruitment.navalbattles.battle.part.AbstractPart;
import com.nespresso.sofa.recruitment.navalbattles.battle.part.Canon;
import com.nespresso.sofa.recruitment.navalbattles.battle.part.Hull;
import com.nespresso.sofa.recruitment.navalbattles.battle.part.Mast;
import com.nespresso.sofa.recruitment.navalbattles.battle.round.FightRoundHandler;
import com.nespresso.sofa.recruitment.navalbattles.race.RaceStrategy;
import com.nespresso.sofa.recruitment.navalbattles.race.RaceStrategyFactory;
import com.nespresso.sofa.recruitment.navalbattles.race.SpeedType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ship extends AbstractShip {

    private final Hull hull;

    private final List<Canon> canons;

    private final List<Mast> masts;

    private final FightRoundHandler<AbstractPart> fightRoundHandler = new FightRoundHandler<>();

    private double health = 0;

    private Defender chain = null;

    public Ship(int displacement, int mast) {
        super(displacement, mast);
        this.masts = createMasts(mast);
        this.canons = createCanons(0);
        this.hull = createHullPart(displacement);
    }

    public Ship(int displacement, int mast, int canonNumber) {
        super(displacement, mast, canonNumber);
        this.masts = createMasts(mast);
        this.canons = createCanons(canonNumber);
        this.hull = createHullPart(displacement);
        health = calculateShipHealth();
    }

    private List<Mast> createMasts(final int valueOfMast) {
        final List<Mast> masts = new LinkedList<>();
        for (int i = 1; i <= valueOfMast; i++) {
            final Mast mast = new Mast();
            masts.add(mast);
            fightRoundHandler.addListener(mast);
            if (chain != null) {
                chain.successor(mast);
            }
            chain = mast;
        }
        return masts;
    }

    private  List<Canon> createCanons(final int canonNumber) {
        final List<Canon> canons = new LinkedList<>();
        for (int i = 1; i <= canonNumber; i++) {
            final Canon canon = new Canon();
            canons.add(canon);
            fightRoundHandler.addListener(canon);
            if (chain != null) {
                chain.successor(canon);
            }
            chain = canon;
        }
        return canons;
    }

    private Hull createHullPart(final int displacement) {
        final Hull hull = new Hull(displacement);
        fightRoundHandler.addListener(hull);
        chain.successor(hull);
        return hull;
    }

    private double calculateShipHealth() {
        double health = hull.health();
        for (final Canon canon : canons) {
            health += canon.health();
        }
        for (final Mast mast : masts) {
            health += mast.health();
        }
        return health;
    }

    public double attack() {
        int numberOfCanons = 0;
        for (final Canon canon : canons) {
            if (!canon.isDestroyed())
                numberOfCanons++;
        }
        return numberOfCanons * 200;
    }

    public void defence(final double damageAccepted) {
        double damageTaken = damageAccepted;
        masts.get(0).defendAgainst(damageAccepted);
        health -= damageTaken;
        if (health <= 0) {
            health = 0;
        }
//        fightRoundHandler.fireEvent();
    }
    public boolean isSunk() {
        return health <= 0;
    }

    @Override
    protected List<RaceStrategy> raceStrategies() {
        return Arrays.asList(RaceStrategyFactory.INSTANCE.createRaceStrategyBySpeedType(SpeedType.WITH_CANON, this));
    }

    @Override
    public String toString() {
        return "Ship{" +
                "health=" + health +
                ", hull=" + hull +
                ", masts=" + masts +
                '}';
    }
}
