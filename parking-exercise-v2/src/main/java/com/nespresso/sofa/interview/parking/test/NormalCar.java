package com.nespresso.sofa.interview.parking.test;

import com.nespresso.sofa.interview.parking.bay.AbstractBay;

public class NormalCar extends Car{
    @Override
    public void visit(AbstractBay bay) {
        bay.accept(this);
    }
}
