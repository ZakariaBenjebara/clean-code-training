package com.nespresso.sofa.recruitment.navalbattles.battle;

public abstract class Defender {

    protected Defender successor;

    public void successor(final Defender successor) {
        this.successor = successor;
    }

    public abstract void defendAgainst(double attack);
}
