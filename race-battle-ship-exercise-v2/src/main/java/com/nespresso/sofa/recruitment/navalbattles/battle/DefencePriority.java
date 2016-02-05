package com.nespresso.sofa.recruitment.navalbattles.battle;

public enum DefencePriority {

    LOWEST(1),

    MIDDLE(2),

    HIGHEST(3);

    private final int value;

    DefencePriority(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
