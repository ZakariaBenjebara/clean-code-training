package com.nespresso.sofa.interview.parking.visitor;

public interface ExitVisitable {
    void accept(BayVisitor visitor);
}
