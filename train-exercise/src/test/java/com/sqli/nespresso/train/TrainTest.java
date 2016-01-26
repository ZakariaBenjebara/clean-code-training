package com.sqli.nespresso.train;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TrainTest {

    @Test
    public void passengerTrain() {
        Train train = new Train("HPP");
        assertEquals("<HHHH::|OOOO|::|OOOO|", train.print());
    }

   @Test
    public void restaurantTrain() {
        Train train = new Train("HPRP");
        assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|", train.print());
    }

    @Test
    public void doubleHeadedTrain() {
        Train train = new Train("HPRPH");
        assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|::HHHH>", train.print());
    }

    @Test
    public void modifyTrain() {
        Train train = new Train("HPRPH");
        train.detachEnd();
        assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|", train.print());
        train.detachHead();
        assertEquals("|OOOO|::|hThT|::|OOOO|", train.print());
        train.detachEnd();
        assertEquals("|OOOO|::|hThT|", train.print());
    }


    @Test
    public void cargoTrain() {
        Train train = new Train("HCCC");
        assertEquals("<HHHH::|____|::|____|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|^^^^|::|____|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|^^^^|::|^^^^|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|^^^^|::|^^^^|::|^^^^|", train.print());
        assertFalse(train.fill());
    }

    @Test
    public void mixedTrain() {
        Train train = new Train("HPCPC");
        assertEquals("<HHHH::|OOOO|::|____|::|OOOO|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|OOOO|::|^^^^|::|OOOO|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|OOOO|::|^^^^|::|OOOO|::|^^^^|", train.print());
        assertFalse(train.fill());
    }
}
