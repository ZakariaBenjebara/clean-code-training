package com.nespresso.sofa.interview.parking;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;
import com.nespresso.sofa.interview.parking.bay.BayFactory;
import com.nespresso.sofa.interview.parking.visitor.BayVisitor;
import com.nespresso.sofa.interview.parking.visitor.PedestrianVisitable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Builder class to get a parking instance
 */
public class ParkingBuilder {

    private final List<AbstractBay> bays = new ArrayList<>();

    private final List<PedestrianVisitable> pedestrians = new ArrayList<>();

    public ParkingBuilder withSquareSize(final int size) {
        final int dimension = size * size;
        for (int i = 0; i < dimension; i++) {
            bays.add(BayFactory.NORMAL_PEOPLE.create(i));
        }
        return this;
    }

    public ParkingBuilder withPedestrianExit(final int pedestrianExitIndex) {
        final AbstractBay pedestrian = BayFactory.PEDESTRIAN.create(pedestrianExitIndex);
        bays.set(pedestrianExitIndex, pedestrian);
        pedestrians.add((PedestrianVisitable) pedestrian);
        return this;
    }
    public ParkingBuilder withDisabledBay(final int disabledBayIndex) {
        final AbstractBay disabled = BayFactory.DISABLED_PEOPLE.create((disabledBayIndex));
        bays.set(disabledBayIndex, disabled);
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
