package com.nespresso.sofa.interview.parking.bay;

import com.nespresso.sofa.interview.parking.visitor.BayVisitor;
import com.nespresso.sofa.interview.parking.visitor.PedestrianVisitable;
import com.nespresso.sofa.interview.parking.writer.ParkingWriter;

final class Pedestrian extends AbstractBay implements PedestrianVisitable {

    public Pedestrian(int number) {
        super(number);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void accept(final BayVisitor visitor) {
        visitor.visit(this.number);
    }

    @Override
    public void write(final ParkingWriter writer) {
        writer.emitPedestrianExit();
    }
}
