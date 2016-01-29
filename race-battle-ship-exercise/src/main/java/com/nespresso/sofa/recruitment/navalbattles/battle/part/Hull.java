package com.nespresso.sofa.recruitment.navalbattles.battle.part;

public class Hull extends AbstractPart {

    private static final int TON_UNIT = 1000;

    private final int displacement;

    public Hull(int displacement) {
        this.displacement = displacement;
        this.health = calculateHealth(displacement);
    }

    private double calculateHealth(int displacement) {
        if (displacement <= 0) {
            throw new IllegalArgumentException();
        }
        return (double) displacement / TON_UNIT;
    }
}
