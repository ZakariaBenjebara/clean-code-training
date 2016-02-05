package com.nespresso.sofa.recruitment.navalbattles.battle;

import com.nespresso.sofa.recruitment.navalbattles.batteau.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BattleSide {

    private final List<Ship> ships;

    public BattleSide() {
        this.ships = new ArrayList<>();
    }

    public void reinforceSide(final Ship[] members) {
        if (members == null) {
            throw new IllegalArgumentException("Missing the member to the side");
        }
        for (final Ship member : members) {
            ships.add(member);
        }
    }

    public boolean containsSide(final Ship side) {
        return ships.contains(side);
    }

    public void attack(final BattleSide otherSide) {
        for (final Ship ship : ships) {
            if (ship.isSunk())
                continue;
            if (!otherSide.defend(ship.attack())) {
                return;
            }
        }
    }

    public boolean defend(final double attack) {
        for (final Ship ship : ships) {
            if (!ship.isSunk()) {
                ship.defence(attack);
                return true;
            }
        }
        return false;
    }

    public boolean isSunk() {
        for (final Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "BattleSide{" +
                "ships=" + ships +
                '}';
    }
}
