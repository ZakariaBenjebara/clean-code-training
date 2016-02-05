package com.nespresso.sofa.recruitment.navalbattles.batteau;

public class Ship extends AbstractShip {

    private static final double SPEED_PENALTY = .005;

    final int numberOfCanons;

    public Ship(int displacement, int mast) {
        super(displacement, mast);
        numberOfCanons = 0;
    }

    public Ship(int displacement, int mast, int numberOfCanons) {
        super(displacement, mast);
        this.numberOfCanons = numberOfCanons;
    }

    @Override
    public double speed() {
        double adoptedSpeed = baseSpeed();
        for (int i = 0; i < numberOfCanons; i++) {
            adoptedSpeed += adoptedSpeed * SPEED_PENALTY;
        }
        return adoptedSpeed;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("ships equals");
        System.out.println(o);
        System.out.println(this);
        if (this == o) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return numberOfCanons;
    }
}
