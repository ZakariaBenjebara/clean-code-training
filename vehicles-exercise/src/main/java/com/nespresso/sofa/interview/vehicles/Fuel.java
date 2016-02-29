package com.nespresso.sofa.interview.vehicles;

public enum Fuel {

    DIESEL("Diesel", 0.05f), GASOLINE("Gasoline", 0.06f), HYBRID("Hybrid", 0.03f);

    private final String nameOfFuel;

    private final float consume;

    Fuel(String nameOfFuel, float consume) {
        this.nameOfFuel = nameOfFuel;
        this.consume = consume;
    }

    public final float consummation(final float distance) {
        return distance * consume;
    }

    public static Fuel of(final String nameOfFuel) {
        for (final Fuel fuel : values()) {
            if (nameOfFuel.equals(fuel.nameOfFuel))
                return fuel;
        }
        throw new IllegalArgumentException();
    }
}
