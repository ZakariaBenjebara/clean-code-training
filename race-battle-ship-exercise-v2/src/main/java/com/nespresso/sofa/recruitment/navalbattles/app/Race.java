package com.nespresso.sofa.recruitment.navalbattles.app;

import com.nespresso.sofa.recruitment.navalbattles.batteau.AbstractShip;
import com.sun.org.apache.xerces.internal.xs.LSInputList;

import java.util.*;

public class Race {

    private final List<AbstractShip> ships;

    public Race(final AbstractShip... ships) {
        this.ships = createShips(ships);
    }

    private List<AbstractShip> createShips(final AbstractShip[] ships) {
        if (ships == null) {
            throw new NullPointerException("Missing the ships values");
        }
        final List<AbstractShip> listOfShips = new ArrayList<>();
        for (final AbstractShip ship : ships) {
            listOfShips.add(ship);
        }
        return Collections.unmodifiableList(listOfShips);
    }

    public AbstractShip winner() {
        final List<AbstractShip> racers = new ArrayList<>(ships);
        Collections.sort(racers);
        return racers.get(0);
    }
}
