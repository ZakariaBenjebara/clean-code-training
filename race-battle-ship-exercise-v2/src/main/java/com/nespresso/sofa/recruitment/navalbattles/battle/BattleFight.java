package com.nespresso.sofa.recruitment.navalbattles.battle;

import com.nespresso.sofa.recruitment.navalbattles.batteau.BattleShip;
import com.nespresso.sofa.recruitment.navalbattles.batteau.Ship;

public class BattleFight {

    private final BattleSide winner;

    public BattleFight(final BattleSide allieSide, final BattleSide enemySide) {
        winner = fight(allieSide, enemySide);
    }

    private BattleSide fight(final BattleSide allieSide, final BattleSide enemySide) {
        do {
            allieSide.attack(enemySide);
            enemySide.attack(allieSide);
        } while (!allieSide.isSunk() && !enemySide.isSunk());
        return allieSide.isSunk() ? enemySide : allieSide;
    }

    public boolean isInTheWinningSide(final Ship shipSide) {
        return winner.containsShip(new BattleShip(shipSide));
    }

    @Override
    public String toString() {
        return "BattleFight{" +
                "winner=" + winner +
                '}';
    }
}
