package com.nespresso.sofa.interview.vehicles;

public enum VehicleType {
    CAR, TRUCK, MOTORCYCLE;

    public static VehicleType fromString(final String representation) {
        for (final VehicleType vehicleType : values()) {
            if (vehicleType.name().equals(representation))
                return vehicleType;
        }
        throw new IllegalArgumentException();
    }
}
