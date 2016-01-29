package com.nespresso.sofa.interview.parking;

public class Vehicle {

    private final char type;

    public Vehicle(char type) {
        this.type = type;
    }

    public boolean isForDisabledPeople() {
        return type == 'D';
    }

    @Override
    public String toString() {
        return  String.valueOf(type);
    }
}
