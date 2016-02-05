package com.nespresso.sofa.recruitment.navalbattles.batteau;

public class Clipper extends AbstractShip {

    private final static double SPEED_BONUS = 0.2;

    public Clipper(int displacement, int mast) {
        super(displacement, mast);
    }

    @Override
    public double speed() {
        return baseSpeed() - (baseSpeed() * SPEED_BONUS);
    }
}
