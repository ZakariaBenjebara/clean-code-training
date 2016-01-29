package com.nespresso.sofa.interview.parking.visitor;

import com.nespresso.sofa.interview.parking.bay.PedestrianBay;

public interface BayVisitor {
    void visit(PedestrianBay bay);
}
