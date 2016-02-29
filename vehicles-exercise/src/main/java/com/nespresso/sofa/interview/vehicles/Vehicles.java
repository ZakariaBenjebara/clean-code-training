package com.nespresso.sofa.interview.vehicles;

import java.util.HashMap;
import java.util.Map;

public class Vehicles {

    private final Map<VehicleType, Vehicle> vehicles;

    public Vehicles(final String vehicles) {
        this.vehicles = VehicleParser.parseVehicles(vehicles);
    }

    public String move(final String car, final String doorsRepresentation, final String distanceRepresentation) {
        final Vehicle vehicle = vehicles.get(VehicleType.fromString(car));
        final int[] doors = VehicleParser.parseDoors(doorsRepresentation);
        final float distance = VehicleParser.parseDistance(distanceRepresentation);
        return vehicle.move(doors, distance);
    }

    static final class VehicleParser {

        static int[] parseDoors(final String doors) {
            final char[] doorsNumber = doors.replaceAll("\\s+", "").toCharArray();
            final int[] list = new int[doorsNumber.length];
            for (int i = 0; i < doorsNumber.length; i++) {
                list[i] = Integer.parseInt(String.valueOf(doorsNumber[i]));
            }
            return list;
        }

        static float parseDistance(final String distance) {
            return Float.valueOf(distance.split(" ")[0]);
        }

        static Map<VehicleType, Vehicle> parseVehicles(final String vehicles) {
            final Map<VehicleType, Vehicle> vehicleMap = new HashMap<>();
            final String[] vlist = vehicles.split(", ");
            for (final String vehicle : vlist) {
                final String[] vpart = vehicle.split(":");
                final VehicleType vehicleType = VehicleType.fromString(vpart[0]);
                final Fuel fuel = Fuel.of(vpart[1]);
                final int doorNumber = Integer.valueOf(vpart[2]);
                vehicleMap.put(vehicleType, new Vehicle(vehicleType, fuel, doorNumber));
            }
            return vehicleMap;
        }
    }
}
