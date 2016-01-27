package com.nespresso.sofa.recruitment.navalbattles.battle.round;

import java.util.List;

public final class FightRoundHandler {

    private final List<FightRoundListener> listeners;

    public FightRoundHandler(final List<FightRoundListener> listeners) {
        this.listeners = listeners;
    }

    public void fireEvent() {
        for (final FightRoundListener listener : listeners) {
            listener.onRoundFight();
        }
    }
}
