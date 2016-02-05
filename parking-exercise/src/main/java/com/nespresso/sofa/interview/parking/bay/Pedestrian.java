package com.nespresso.sofa.interview.parking.bay;

import com.nespresso.sofa.interview.parking.visitor.ExitVisitable;
import com.nespresso.sofa.interview.parking.Vehicle;
import com.nespresso.sofa.interview.parking.strategy.ParkingStrategy;
import com.nespresso.sofa.interview.parking.strategy.ParkingStrategyFactory;
import com.nespresso.sofa.interview.parking.visitor.BayVisitor;
import com.nespresso.sofa.interview.parking.writer.WriterType;
import com.nespresso.sofa.interview.parking.writer.BayWriterFactory;
import com.nespresso.sofa.interview.parking.writer.Writable;

public class Pedestrian extends AbstractBay implements ExitVisitable {

    private final ParkingStrategy parkingStrategy = ParkingStrategyFactory.INSTANCE.createParkingStrategyByBayType(WriterType.PEDESTRIAN, this);

    public Pedestrian(int bayNumber) {
        super(bayNumber);
    }

    @Override
    public boolean isAvailable() {
        // TODO : call the strategy
        return false;
    }

    @Override
    public boolean canPark(final Vehicle vehicle) {
        return parkingStrategy.canPark(vehicle);
    }

    @Override
    public int park(final Vehicle vehicle) {
        return -1;
    }

    @Override
    public boolean unpark() {
        return false;
    }

    @Override
    public Writable createWriter() {
        return BayWriterFactory.INSTANCE.createWriter(WriterType.PEDESTRIAN, null);
    }

    @Override
    public void accept(final BayVisitor visitor) {
        visitor.visit(this);
    }
}
