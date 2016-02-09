package com.nespresso.sofa.interview.parking.visitor;

public interface PedestrianVisitable {
    void accept(BayVisitor visitor);
}
