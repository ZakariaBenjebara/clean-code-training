package com.nespresso.sofa.recruitment.navalbattles.app;

import com.nespresso.sofa.recruitment.navalbattles.batteau.Ship;
import com.nespresso.sofa.recruitment.navalbattles.battle.BattleSide;

public class Battle {

    private final BattleSide allieSide;

    private final BattleSide enemySide;

    public Battle() {
        this.allieSide = new BattleSide();
        this.enemySide = new BattleSide();
    }

    public Battle side(final Ship... allies) {
        allieSide.reinforceSide(allies);
        return this;
    }

    public Battle against(final Ship... enemies) {
        enemySide.reinforceSide(enemies);
        return this;
    }


    public boolean isInTheWinningSide(final Ship side) {
        return false;
    }
}
