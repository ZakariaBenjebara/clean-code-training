package com.nespresso.sofa.interview.parking.bay;

import com.nespresso.sofa.interview.parking.Car;
import com.nespresso.sofa.interview.parking.writer.ParkingWriter;

final class ForNormalPeople extends AbstractBayForCar {

    public ForNormalPeople(int number) {
        super(number);
    }

    @Override
    protected boolean acceptCar(final Car car) {
        return !car.isForDisabledPeople();
    }

    @Override
    public void write(final ParkingWriter writer) {
        if (!isAvailable()) parkedCar.write(writer);
        else writer.emitEmptyNormalBay();
    }
}
