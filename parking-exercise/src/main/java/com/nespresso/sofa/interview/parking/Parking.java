package com.nespresso.sofa.interview.parking;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;
import com.nespresso.sofa.interview.parking.writer.ParkingPrinter;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Handles the parking mechanisms: park/unpark a car (also for disabled-only bays) and provides a string representation of its state.
 */
public class Parking {

    private final List<AbstractBay> bays;

    public Parking(List<AbstractBay> bays) {
        this.bays = bays;
    }

    /**
     * @return the number of available parking bays left
     */
    public int getAvailableBays() {
        int availableBays = 0;
        for (final AbstractBay bay : bays) {
            if (bay.isAvailable())
                availableBays++;
        }
        return availableBays;
    }

    /**
     * Park the car of the given type ('D' being dedicated to disabled people) in closest -to pedestrian exit- and first (starting from the parking's entrance)
     * available bay. Disabled people can only park on dedicated bays.
     *
     * @param carType the car char representation that has to be parked
     * @return bay index of the parked car, -1 if no applicable bay found
     */
    public int parkCar(final char carType) {
        final Vehicle vehicle = new Vehicle(carType);
        final List<AbstractBay> orderedBays = new LinkedList<>(bays);
        Collections.sort(orderedBays);
        for (final AbstractBay bay : orderedBays) {
            if (bay.canPark(vehicle)) {
                return bay.park(vehicle);
            }
        }
        return -1;
    }

    /**
     * Unpark the car from the given index
     *
     * @param index
     * @return true if a car was parked in the bay, false otherwise
     */
    public boolean unparkCar(final int index) {
        final AbstractBay bay = findBayByNumber(index);
        return bay.unpark();
    }

    /**
     * Print a 2-dimensional representation of the parking with the following rules:
     * <ul>
     * <li>'=' is a pedestrian exit
     * <li>'@' is a disabled-only empty bay
     * <li>'U' is a non-disabled empty bay
     * <li>'D' is a disabled-only occupied bay
     * <li>the char representation of a parked vehicle for non-empty bays.
     * </ul>
     * U, D, @ and = can be considered as reserved chars.
     * <p>
     * Once an end of lane is reached, then the next lane is reversed (to represent the fact that cars need to turn around)
     *
     * @return the string representation of the parking as a 2-dimensional square. Note that cars do a U turn to continue to the next lane.
     */
    @Override
    public String toString() {
        try {
            return ParkingPrinter.printBays(bays);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    private AbstractBay findBayByNumber(int bayNumber) {
        for (final AbstractBay bay : bays) {
            if (bay.equalsNumber(bayNumber))
                return bay;
        }
        throw new NoSuchElementException(String.format("Not found any result for the bay number '%d'", bayNumber));
    }
}
