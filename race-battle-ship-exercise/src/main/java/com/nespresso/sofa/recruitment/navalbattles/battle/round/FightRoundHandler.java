package com.nespresso.sofa.recruitment.navalbattles.battle.round;

import java.util.LinkedList;
import java.util.List;

public final class FightRoundHandler<T extends  FightRoundListener> {

    private List<T> listeners = new LinkedList<>();

    public FightRoundHandler() {}

    public void addListener(T listener) {
        listeners.add(listener);
    }

    public void addListeners(T... listeners) {
        for (final T listener : listeners) {
            addListener(listener);
        }
    }

    public void fireEvent() {
        for (final FightRoundListener listener : listeners) {
            listener.onRoundFight();
        }
    }
}
