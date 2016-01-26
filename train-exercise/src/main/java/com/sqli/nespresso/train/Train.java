package com.sqli.nespresso.train;

import com.sqli.nespresso.train.factory.WagonFactory;
import com.sqli.nespresso.train.utils.Preconditions;
import com.sqli.nespresso.train.wagon.Wagon;
import com.sqli.nespresso.train.wagon.WagonType;
import com.sqli.nespresso.train.writer.WagonPrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Train {

    private final List<Wagon> wagons;

    public Train(String representation) {
        this.wagons = createWagons(representation);
    }

    public String print() {
        try {
            return WagonPrinter.printWagons(wagons);
        } catch (IOException e){
            throw new IllegalStateException("Error when trying to print wagons");
        }
    }

    public void detachEnd() {
        Preconditions.assertNotEmpty(wagons);
        final Wagon detach = wagons.get(wagons.size() - 1);
        wagons.remove(detach);
    }

    public void detachHead() {
        Preconditions.assertNotEmpty(wagons);
        final Wagon detach = wagons.get(0);
        wagons.remove(detach);
    }

    public boolean fill() {
        Preconditions.assertNotEmpty(wagons);
        for (final Wagon wagon : wagons) {
            if(wagon.fill()) {
                return true;
            }
        }
        return false;
    }

    private List<Wagon> createWagons(String representation) {
        Preconditions.assertNotNull(representation);
        final char[] wagonIds = representation.toCharArray();
        final List<Wagon> wagons = new ArrayList<>();
        for (int i = 0; i < wagonIds.length; i++) {
            final char wagonId = wagonIds[i];
            wagons.add(createWagon(wagonId));
        }
        return wagons;
    }

    private Wagon createWagon(final char wagonId) {
        final WagonType wagonType = WagonType.fromCharConstant(wagonId);
        return WagonFactory.INSTANCE.createWagon(wagonType);
    }
}
