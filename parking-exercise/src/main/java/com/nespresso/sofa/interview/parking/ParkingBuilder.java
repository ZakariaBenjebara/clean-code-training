package com.nespresso.sofa.interview.parking;

import com.nespresso.sofa.interview.parking.bay.ForDisabledBay;
import com.nespresso.sofa.interview.parking.bay.PedestrianBay;
import com.nespresso.sofa.interview.parking.bay.Bay;
import com.nespresso.sofa.interview.parking.bay.NonDisabledBay;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Builder class to get a parking instance
 */
public class ParkingBuilder {

    private LinkedList<Bay> bays;

    private List<PedestrianBay> pedestrianBays = new LinkedList<>();

    public ParkingBuilder withSquareSize(final int size) {
        final int parkDimension = size * size;
        bays = new LinkedList<>();
        for (int i = 0; i < parkDimension; i++) {
            final Bay bay = new NonDisabledBay(i);
            bays.add(bay);
        }
        return this;
    }

    public ParkingBuilder withPedestrianExit(final int pedestrianExitIndex) {
        PedestrianBay pedestrian = new PedestrianBay(pedestrianExitIndex);
        bays.set(pedestrianExitIndex, pedestrian);
        pedestrianBays.add(pedestrian);
        return this;
    }

    private void visitPedestrian(PedestrianBay pedestrian) {
        assert pedestrian instanceof PedestrianBay;
        for (final Bay bay : bays) {
            if (bay instanceof ForDisabledBay) {
                pedestrian.accept((ForDisabledBay) bay);
            } else if (bay instanceof NonDisabledBay) {
                pedestrian.accept((NonDisabledBay) bay);
            }
        }
    }

    public ParkingBuilder withDisabledBay(final int disabledBayIndex) {
        bays.set(disabledBayIndex, new ForDisabledBay(disabledBayIndex));
        return this;
    }

    public Parking build() {
        for (PedestrianBay pedestrian : pedestrianBays) {
            visitPedestrian(pedestrian);
        }
        return new Parking(Collections.unmodifiableList(bays));
    }
}
