package com.nespresso.sofa.interview.parking;

import com.nespresso.sofa.interview.parking.writer.WriterType;
import com.nespresso.sofa.interview.parking.writer.BayWriterFactory;
import com.nespresso.sofa.interview.parking.writer.Writable;

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

    public Writable createWriter() {
        return BayWriterFactory.INSTANCE.createWriter(WriterType.OCCUPIED, type);
    }
}
