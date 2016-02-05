package com.nespresso.sofa.recruitment.navalbattles.battle;

public final class BattleFight {

    private final BattleSide allie;

    private final BattleSide enemy;

    public BattleFight(BattleSide allie, BattleSide enemy) {
        this.allie = allie;
        this.enemy = enemy;
    }

    public BattleSide fight() {
        do {
            enemy.attack(allie);
            allie.attack(enemy);
        } while (!enemy.isSunk() && !allie.isSunk());

        return enemy.isSunk() ? allie : enemy;
    }
}
