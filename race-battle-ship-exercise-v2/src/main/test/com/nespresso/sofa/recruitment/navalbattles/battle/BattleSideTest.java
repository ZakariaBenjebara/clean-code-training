package com.nespresso.sofa.recruitment.navalbattles.battle;

import com.nespresso.sofa.recruitment.navalbattles.app.Battle;
import com.nespresso.sofa.recruitment.navalbattles.batteau.Ship;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class BattleSideTest {

    private BattleSide allie;

    private BattleSide enemy;

    @Before
    public void initTest() {
        Ship a = new Ship(65000, 3, 64);
        Ship b = new Ship(23000, 1, 24);
        Ship c = new Ship(23000, 1, 24);
        Ship d = new Ship(23000, 1, 24);

        allie = new BattleSide();
        allie.reinforceSide(a);

        enemy = new BattleSide();
        enemy.reinforceSide(b, c, d);

    }

    @Test
    public void test_how_is_sunk() {
        assertEquals(74400, allie.ship(0).getHitPoints());
        assertEquals(34320, enemy.ship(0).getHitPoints());
        assertEquals(34320, enemy.ship(1).getHitPoints());
        assertEquals(34320, enemy.ship(2).getHitPoints());
        allie.attack(enemy);
        enemy.attack(allie);
        assertEquals(60000, allie.ship(0).getHitPoints());
        assertEquals(17680, enemy.ship(0).getHitPoints());
        assertEquals(34320, enemy.ship(1).getHitPoints());
        assertEquals(34320, enemy.ship(2).getHitPoints());
        allie.attack(enemy);
        enemy.attack(allie);
        assertEquals(45600, allie.ship(0).getHitPoints());
        assertEquals(1040, enemy.ship(0).getHitPoints());
        assertEquals(34320, enemy.ship(1).getHitPoints());
        assertEquals(34320, enemy.ship(2).getHitPoints());
        allie.attack(enemy);
        enemy.attack(allie);
        assertEquals(31200, allie.ship(0).getHitPoints());
        assertEquals(0, enemy.ship(0).getHitPoints());
        assertEquals(16560, enemy.ship(1).getHitPoints());
        assertEquals(30360, enemy.ship(2).getHitPoints());
        allie.attack(enemy);
        enemy.attack(allie);
        assertEquals(16800, allie.ship(0).getHitPoints());
        assertEquals(0, enemy.ship(0).getHitPoints());
        assertEquals(1600, enemy.ship(1).getHitPoints());
        assertEquals(26400, enemy.ship(2).getHitPoints());
        allie.attack(enemy);
        enemy.attack(allie);
        assertEquals(2400, allie.ship(0).getHitPoints());
        assertEquals(0, enemy.ship(0).getHitPoints());
        assertEquals(0, enemy.ship(1).getHitPoints());
        assertEquals(15200, enemy.ship(2).getHitPoints());
        allie.attack(enemy);
        enemy.attack(allie);
        assertEquals(0, allie.ship(0).getHitPoints());
        assertEquals(0, enemy.ship(0).getHitPoints());
        assertEquals(0, enemy.ship(1).getHitPoints());
        assertEquals(2400, enemy.ship(2).getHitPoints());
        assertThat(enemy.ship(2).isSunk()).isFalse();
    }
}