package com.nespresso.sofa.interview.vehicles;

public enum Fuel {

    DIESEL("Diesel", 0.05f), GASOLINE("Gasoline", 0.06f), HYBRID("Hybrid", 0.03f);

    private final String nameOfFuel;

    private final float consummation;

    Fuel(String nameOfFuel, float consummation) {
        this.nameOfFuel = nameOfFuel;
        this.consummation = consummation;
    }

    public final float consumption(final float distance) {
        return distance * consummation;
    }

    public static Fuel of(final String nameOfFuel) {
        for (final Fuel fuel : values()) {
            if (nameOfFuel.equals(fuel.nameOfFuel))
                return fuel;
        }
        throw new IllegalArgumentException();
    }
}
