package com.nespresso.sofa.interview.parking;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;
import com.nespresso.sofa.interview.parking.bay.BayFactory;
import com.nespresso.sofa.interview.parking.visitor.BayVisitor;
import com.nespresso.sofa.interview.parking.visitor.PedestrianVisitable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Builder class to get a parking instance
 */
public class ParkingBuilder {

    private final List<AbstractBay> bays = new LinkedList<>();

    private final List<PedestrianVisitable> pedestrians = new ArrayList<>();

    public ParkingBuilder withSquareSize(final int size) {
        final int dimension = size * size;
        for (int number = 0; number < dimension; number++) {
            bays.add(BayFactory.NORMAL_PEOPLE.create(number));
        }
        return this;
    }

    public ParkingBuilder withPedestrianExit(final int pedestrianExitNumber) {
        final AbstractBay pedestrian = BayFactory.PEDESTRIAN.create(pedestrianExitNumber);
        bays.set(pedestrianExitNumber, pedestrian);
        pedestrians.add((PedestrianVisitable) pedestrian);
        return this;
    }
    public ParkingBuilder withDisabledBay(final int disabledBayNumber) {
        final AbstractBay disabled = BayFactory.DISABLED_PEOPLE.create((disabledBayNumber));
        bays.set(disabledBayNumber, disabled);
        return this;
    }

    public Parking build() {
        for (final PedestrianVisitable pedestrian : pedestrians) {
            visitPedestrian(pedestrian);
        }
        return new Parking(Collections.unmodifiableList(bays));
    }

    private void visitPedestrian(final PedestrianVisitable pedestrian) {
        for (final AbstractBay bay : bays) {
            if (bay instanceof BayVisitor) {
                final BayVisitor bayVisitor = (BayVisitor) bay;
                pedestrian.accept(bayVisitor);
            }
        }
    }
}
