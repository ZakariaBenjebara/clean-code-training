package com.nespresso.sofa.interview.parking.visitor;

import com.nespresso.sofa.interview.parking.bay.Pedestrian;

public interface BayVisitor {
    void visit(Pedestrian bay);
}
