package com.nespresso.sofa.interview.parking.bay;

import com.nespresso.sofa.interview.parking.Vehicle;
import com.nespresso.sofa.interview.parking.strategy.ParkingStrategy;
import com.nespresso.sofa.interview.parking.strategy.ParkingStrategyFactory;
import com.nespresso.sofa.interview.parking.visitor.BayVisitor;
import com.nespresso.sofa.interview.parking.writer.BayWriterFactory;
import com.nespresso.sofa.interview.parking.writer.Writable;

public class ForDisabled extends DefaultParkedBay implements BayVisitor {

    private final ParkingStrategy parkingStrategy;

    public ForDisabled(int bayNumber) {
        super(bayNumber);
        parkingStrategy = ParkingStrategyFactory.INSTANCE.createParkingStrategyByBayType(BayType.DISABLED, this);
    }

    @Override
    public boolean canPark(final Vehicle vehicle) {
        return parkingStrategy.canPark(vehicle);
    }

    @Override
    public Writable createWriter() {
        if (parkedVehicle !=  null)
            return BayWriterFactory.INSTANCE.createWriter(BayType.OCCUPIED, parkedVehicle);
        return BayWriterFactory.INSTANCE.createWriter(BayType.DISABLED, this);
    }
}
