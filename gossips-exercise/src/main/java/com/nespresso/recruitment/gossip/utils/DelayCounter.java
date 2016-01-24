package com.nespresso.recruitment.gossip.utils;

public final class DelayCounter {

    private final int delay;

    private int counter = 1;

    public DelayCounter(final int delay) {
        assert delay > 0;
        this.delay = delay;
    }

    public synchronized boolean nextRound() {
        if (delay == counter) {
            counter = 1;
            return true;
        }
        counter++;
        return false;
    }
}
