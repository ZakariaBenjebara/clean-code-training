package com.nespresso.sofa.interview.parking.visitor;

import com.nespresso.sofa.interview.parking.PedestrianBay;

public interface BayVisitor {
    void visit(PedestrianBay bay);
}
