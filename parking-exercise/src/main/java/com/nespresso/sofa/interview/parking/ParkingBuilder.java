package com.nespresso.sofa.interview.parking;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;
import com.nespresso.sofa.interview.parking.bay.ForDisabled;
import com.nespresso.sofa.interview.parking.bay.Pedestrian;
import com.nespresso.sofa.interview.parking.bay.NonDisabled;

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
            final AbstractBay bay = new NonDisabled(i);
            bays.add(bay);
        }
        return this;
    }

    public ParkingBuilder withPedestrianExit(final int pedestrianExitIndex) {
        Pedestrian pedestrian = new Pedestrian(pedestrianExitIndex);
        bays.set(pedestrianExitIndex, pedestrian);
        pedestrianBays.add(pedestrian);
        return this;
    }

    private void visitPedestrian(Pedestrian pedestrian) {
        assert pedestrian instanceof Pedestrian;
        for (final AbstractBay bay : bays) {
            if (bay instanceof ForDisabled) {
                pedestrian.accept((ForDisabled) bay);
            } else if (bay instanceof NonDisabled) {
                pedestrian.accept((NonDisabled) bay);
            }
        }
    }

    public ParkingBuilder withDisabledBay(final int disabledBayIndex) {
        bays.set(disabledBayIndex, new ForDisabled(disabledBayIndex));
        return this;
    }

    public Parking build() {
        for (Pedestrian pedestrian : pedestrianBays) {
            visitPedestrian(pedestrian);
        }
        return new Parking(Collections.unmodifiableList(bays));
    }
}
