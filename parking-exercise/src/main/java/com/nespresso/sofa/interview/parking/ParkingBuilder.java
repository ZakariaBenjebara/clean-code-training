package com.nespresso.sofa.interview.parking;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;
import com.nespresso.sofa.interview.parking.bay.ForDisabledPeople;
import com.nespresso.sofa.interview.parking.bay.Pedestrian;
import com.nespresso.sofa.interview.parking.bay.NonDisabledPeople;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Builder class to get a parking instance
 */
public class ParkingBuilder {

    private LinkedList<AbstractBay> bays;

    private List<Pedestrian> pedestrianBays = new LinkedList<>();

    public ParkingBuilder withSquareSize(final int size) {
        final int parkDimension = size * size;
        bays = new LinkedList<>();
        for (int i = 0; i < parkDimension; i++) {
            final AbstractBay bay = new NonDisabledPeople(i);
            bays.add(bay);
        }
        return this;
    }

    public ParkingBuilder withPedestrianExit(final int pedestrianExitIndex) {
        final Pedestrian pedestrian = new Pedestrian(pedestrianExitIndex);
        bays.set(pedestrianExitIndex, pedestrian);
        pedestrianBays.add(pedestrian);
        return this;
    }

    private void visitPedestrian(final Pedestrian pedestrian) {
        for (final AbstractBay bay : bays) {
            if (bay instanceof ForDisabledPeople) {
                pedestrian.accept((ForDisabledPeople) bay);
            } else if (bay instanceof NonDisabledPeople) {
                pedestrian.accept((NonDisabledPeople) bay);
            }
        }
    }

    public ParkingBuilder withDisabledBay(final int disabledBayIndex) {
        bays.set(disabledBayIndex, new ForDisabledPeople(disabledBayIndex));
        return this;
    }

    public Parking build() {
        for (final Pedestrian pedestrian : pedestrianBays) {
            visitPedestrian(pedestrian);
        }
        return new Parking(Collections.unmodifiableList(bays));
    }
}
