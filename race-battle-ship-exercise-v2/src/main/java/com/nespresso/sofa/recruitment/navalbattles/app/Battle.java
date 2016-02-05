package com.nespresso.sofa.recruitment.navalbattles.app;

import com.nespresso.sofa.recruitment.navalbattles.batteau.Ship;
import com.nespresso.sofa.recruitment.navalbattles.battle.BattleFight;
import com.nespresso.sofa.recruitment.navalbattles.battle.BattleSide;

public class Battle {

    private final BattleSide allieSide = new BattleSide();

    private final BattleSide enemySide = new BattleSide();

    private BattleFight battleFight = null;

    public Battle side(final Ship... allies) {
        if (allies == null) {
            throw new IllegalArgumentException("allies == null");
        }
        allieSide.reinforceSide(allies);
        return this;
    }

    public Battle against(final Ship... enemies) {
        if (enemies == null) {
            throw new IllegalArgumentException("enemies == null");
        }
        enemySide.reinforceSide(enemies);
        battleFight = new BattleFight(allieSide, enemySide);
        return this;
    }

    public boolean isInTheWinningSide(final Ship shipSide) {
        System.out.println(battleFight);
        return battleFight.isInTheWinningSide(shipSide);
    }

    @Override
    public String toString() {
        return "Battle{" +
                "battleFight=" + battleFight +
                '}';
    }
}
