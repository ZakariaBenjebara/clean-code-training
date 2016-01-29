package com.nespresso.sofa.interview.parking;

import com.nespresso.sofa.interview.parking.bay.Bay;
import com.nespresso.sofa.interview.parking.bay.BayType;
import com.nespresso.sofa.interview.parking.strategy.ParkingStrategy;
import com.nespresso.sofa.interview.parking.strategy.ParkingStrategyFactory;
import com.nespresso.sofa.interview.parking.visitor.BayVisitor;
import com.nespresso.sofa.interview.parking.visitor.ExitVisitable;
import com.nespresso.sofa.interview.parking.writer.BayWriterFactory;
import com.nespresso.sofa.interview.parking.writer.Writable;

public class PedestrianBay extends Bay implements ExitVisitable {

    private final ParkingStrategy parkingStrategy = ParkingStrategyFactory.INSTANCE.createParkingStrategyByBayType(BayType.PEDESTRIAN, this);

    public PedestrianBay(int bayNumber) {
        super(bayNumber);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        return parkingStrategy.canPark(vehicle);
    }

    @Override
    public int park(Vehicle vehicle) {
        return -1;
    }

    @Override
    public boolean unpark() {
        return false;
    }

    @Override
    public Writable createWriter() {
        return BayWriterFactory.INSTANCE.createWriter(BayType.PEDESTRIAN, this);
    }

    @Override
    public void accept(final BayVisitor visitor) {
        visitor.visit(this);
    }
}