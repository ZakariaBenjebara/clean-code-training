package com.nespresso.sofa.recruitment.navalbattles.battle;

import org.junit.Before;
import org.junit.Test;

public class BattleShipTest {

    private BattleShip battleShipAllie;

    private BattleShip battleShipEnemy;

    @Before
    public void init_ships_fpr_battle() {
       battleShipAllie = new BattleShip(7500, 2, 10);
       battleShipEnemy = new BattleShip(7500, 2, 20);
    }

    @Test
    public void battleShip_should_accept_damage() {
        System.out.println(battleShipAllie.health());
        double attack = battleShipEnemy.attack();
        System.out.println(attack);
        battleShipAllie.defence(attack);
        System.out.println(battleShipAllie.health());

    }
}