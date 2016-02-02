package com.nespresso.sofa.recruitment.navalbattles.battle;

import com.nespresso.sofa.recruitment.navalbattles.batteau.Ship;
import org.junit.Before;
import org.junit.Test;

public class BattleShipTest {

    private Ship battleShipAllie;

    private Ship battleShipEnemy;

    @Before
    public void init_ships_for_battle() {
       battleShipAllie = new Ship(7500, 2, 10);
       battleShipEnemy = new Ship(7500, 2, 20);
    }

    @Test
    public void battleShip_should_accept_damage() {
        double attack = battleShipEnemy.attack();
        battleShipAllie.defence(attack);
    }
}