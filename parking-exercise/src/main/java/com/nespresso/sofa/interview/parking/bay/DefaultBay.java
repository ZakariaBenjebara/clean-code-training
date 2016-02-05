package com.nespresso.sofa.interview.parking.bay;

import com.nespresso.sofa.interview.parking.Vehicle;
import com.nespresso.sofa.interview.parking.visitor.BayVisitor;

abstract class DefaultBay extends AbstractBay implements BayVisitor {

    protected Vehicle parkedVehicle = null;

    public DefaultBay(int bayNumber) {
        super(bayNumber);
    }

    @Override
    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    @Override
    public int park(final Vehicle vehicle) {
        parkedVehicle = vehicle;
        return bayNumber;
    }

    @Override
    public boolean unpark() {
        if (parkedVehicle != null) {
            parkedVehicle = null;
            return true;
        }
        return false;
    }

    @Override
    public void visit(final Pedestrian bay) {
        int distance = Math.abs(this.bayNumber - bay.bayNumber);
        if (exitDistance > distance) {
            exitDistance = distance;
        }
    }
}
