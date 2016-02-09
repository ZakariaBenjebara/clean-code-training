package com.nespresso.sofa.interview.parking.bay;

import com.nespresso.sofa.interview.parking.Car;
import com.nespresso.sofa.interview.parking.HasParkingPlace;
import com.nespresso.sofa.interview.parking.visitor.BayVisitor;

abstract class AbstractBayForCar extends AbstractBay implements HasParkingPlace, BayVisitor {

    protected Car parkedCar;

    public AbstractBayForCar(int number) {
        super(number);
    }

    @Override
    public boolean canPark(final Car car) {
        return isAvailable() && acceptCar(car);
    }

    @Override
    public int parkCar(final Car car) {
        parkedCar = car;
        return number;
    }

    @Override
    public boolean unparkCar() {
        if (parkedCar == null)
            return false;
        parkedCar = null;
        return true;
    }

    @Override
    public boolean isAvailable() {
        return parkedCar == null;
    }

    @Override
    public void visit(final int pedestrianNumber) {
        final int distanceFromExit = Math.abs(number - pedestrianNumber);
        if (exitDistance > distanceFromExit)
            exitDistance = distanceFromExit;
    }

    protected abstract boolean acceptCar(Car car);
}
