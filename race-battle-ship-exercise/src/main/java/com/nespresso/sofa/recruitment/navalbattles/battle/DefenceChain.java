package com.nespresso.sofa.recruitment.navalbattles.battle;

public abstract class DefenceChain {

    protected DefenceChain successor;

    public abstract void defendAgainst(double attack);

    public void successor(final DefenceChain successor) {
        this.successor = successor;
    }
}
