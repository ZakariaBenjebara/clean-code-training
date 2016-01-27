package com.nespresso.sofa.recruitment.navalbattles.battle.part;

import com.nespresso.sofa.recruitment.navalbattles.battle.DefenceChain;
import com.nespresso.sofa.recruitment.navalbattles.battle.round.FightRoundListener;

public class AbstractPart extends DefenceChain implements FightRoundListener {

    protected double health;

    private PartState partState = PartState.FINE;

    public boolean isDestroyed() {
        return partState == PartState.DESTROYED;
    }

    public double health() {
        return health;
    }

    @Override
    public void defendAgainst(final double attack) {
        if (isDestroyed()) {
            nextDefender(attack);
            return;
        }
        final double damageTaken = health - attack;
        if (damageTaken <= 0) {
            health = 0;
            partState = PartState.PRE_DESTROY;
            nextDefender(Math.abs(damageTaken));
        } else {
            health -= damageTaken;
        }
    }

    @Override
    public void onRoundFight() {
        if (partState == PartState.PRE_DESTROY)
            partState = PartState.DESTROYED;
    }

    private void nextDefender(double damage) {
        if (successor != null) {
            successor.defendAgainst(damage);
        }
    }
}
