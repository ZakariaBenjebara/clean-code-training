package com.nespresso.sofa.recruitment.navalbattles.battle;

import com.nespresso.sofa.recruitment.navalbattles.batteau.Ship;

import java.util.ArrayList;
import java.util.List;

public final class BattleSide {

    private final List<Ship> ships;

    public BattleSide() {
        this.ships = new ArrayList<>();
    }

    public void reinforceSide(final Ship[] members) {
        if (members == null) {
            throw new NullPointerException("Missing the member to the side");
        }
        for (final Ship member : members) {
            ships.add(member);
        }
    }

    public boolean isShunk() {
        return false;
    }
}
