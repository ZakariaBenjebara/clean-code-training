package com.nespresso.sofa.recruitment.navalbattles.battle;

import com.nespresso.sofa.recruitment.navalbattles.batteau.BattleShip;
import com.nespresso.sofa.recruitment.navalbattles.batteau.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public final class BattleSide implements Observer {

    private List<BattleShip> battleShips = new ArrayList<>();

    private int bonus = 0;

    public void reinforceSide(final Ship... ships) {
        if (ships == null) {
            throw new IllegalArgumentException("ships == null");
        }
        for (final Ship ship : ships) {
            reinforceSide(new BattleShip(ship));
        }
        bonus = battleShips.size() - 1;
        additionalBonus();
    }

    private void reinforceSide(final BattleShip battleShip) {
        if (battleShip == null) {
            throw new IllegalArgumentException("battleship == null");
        }
        battleShips.add(battleShip);
        battleShip.addObserver(this);
    }

    public void attack(final BattleSide otherSide) {
        for (final BattleShip battleShip : battleShips) {
            otherSide.defendAgainst(battleShip.attack());
        }
    }

    public void defendAgainst(Damage damage) {
        for (final BattleShip battleShip : battleShips) {
            if (!damage.canDoDamage())
                return;
                damage = battleShip.defend(damage);
        }
    }

    public boolean isSunk() {
        for (final BattleShip battleShip : battleShips) {
            if (!battleShip.isSunk())
                return true;
        }
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("this ship  is shunk " + o);
        bonus--;
        additionalBonus();
    }

    private void additionalBonus() {
        for (final BattleShip battleShip : battleShips) {
            if (!battleShip.isSunk()) {
                battleShip.updateHitPointsWithBonus(bonus);
                battleShip.calculateHitPoints();
            }
        }
    }

    public boolean containsShip(final BattleShip battleShip) {
        return battleShips.contains(battleShip);
    }

    public BattleShip ship(int index) {
        return battleShips.get(index);
    }

    @Override
    public String toString() {
        return "BattleSide{" +
                "battleShips=" + battleShips +
                '}';
    }
}
