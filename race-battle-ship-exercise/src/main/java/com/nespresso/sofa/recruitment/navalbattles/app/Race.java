package com.nespresso.sofa.recruitment.navalbattles.app;

import com.nespresso.sofa.recruitment.navalbattles.batteau.AbstractShip;

import java.util.ArrayList;
import java.util.List;

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
        return listOfShips;
    }

    public AbstractShip winner() {
        AbstractShip winner = ships.get(0);
        for (final AbstractShip ship : ships) {
            if (ship.speed() < winner.speed())
                winner = ship;
        }
        return winner;
    }

}
