package com.nespresso.sofa.interview.parking;

public interface HasParkingPlace {
    boolean canPark(Car car);
    int parkCar(Car car);
    boolean unparkCar();
}
