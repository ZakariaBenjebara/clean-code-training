package com.nespresso.sofa.recruitment.navalbattles.batteau;

import com.nespresso.sofa.recruitment.navalbattles.batteau.part.AbstractPart;
import com.nespresso.sofa.recruitment.navalbattles.batteau.part.Canon;
import com.nespresso.sofa.recruitment.navalbattles.batteau.part.Hull;
import com.nespresso.sofa.recruitment.navalbattles.batteau.part.Mast;
import com.nespresso.sofa.recruitment.navalbattles.battle.Damage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class BattleShip extends Observable {

    private final Ship ship;

    private final List<AbstractPart> parts;

    private int hitPoints = Integer.MAX_VALUE;

    private int bonusPoints = 0;

    public BattleShip(final Ship ship) {
        this.ship = ship;
        this.parts = new PartBuilder()
                .withDisplacement(ship.displacement)
                .withMast(ship.mast)
                .withNumberOfCanons(ship.numberOfCanons).buildParts();
    }

    public Damage defend(Damage damage) {
        for (final AbstractPart part : parts) {
            damage = part.absorb(damage);
        }
        calculateHitPoints();
        return damage;
    }

    public Damage attack() {
        Damage damage = Damage.NULL_DAMAGE;

        if (isSunk())
            return damage;

        for (final AbstractPart part : parts) {
            damage = part.damagePower(damage);
        }
        return damage;
    }

    @Override
    public boolean equals(Object o) {
        BattleShip that = (BattleShip) o;
        return ship != null ? ship.equals(that.ship) : that.ship == null;
    }

    @Override
    public int hashCode() {
        return ship != null ? ship.hashCode() : 0;
    }

    public boolean isSunk() {
        return hitPoints <= 0;
    }

    public void updateHitPointsWithBonus(int bonus) {
        this.bonusPoints = bonus;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void calculateHitPoints() {

        hitPoints = 0;
        int bonus = 0;
        for (final AbstractPart part : parts) {
            hitPoints = part.adoptHitPoints(hitPoints);
        }
        for (int i = 1; i <= bonusPoints; i++) {
            bonus += (hitPoints * 0.15);
        }
        hitPoints += bonus;
        if (isSunk()) {
            setChanged();
            notifyObservers();
        }
    }

    private static final class PartBuilder {

        private int displacement;

        private int mast;

        private int numberOfCanons;

        PartBuilder() {}

        PartBuilder withDisplacement(final int displacement) {
            this.displacement = displacement;
            return this;
        }

        PartBuilder withMast(final int mast) {
            this.mast = mast;
            return this;
        }

        PartBuilder withNumberOfCanons(final int numberOfCanons) {
            this.numberOfCanons = numberOfCanons;
            return this;
        }

        List<AbstractPart> buildParts() {
            final List<AbstractPart> parts = new ArrayList<>();
            parts.add(new Hull(displacement));
            for (int i = 1; i <= mast; i++) {
                parts.add(new Mast());
            }
            for (int i = 1; i <= numberOfCanons; i++) {
                parts.add(new Canon());
            }
            Collections.sort(parts);
            return Collections.unmodifiableList(parts);
        }
    }

    @Override
    public String toString() {
        return "BattleShip{" +
                "ship=" + ship +
                ", parts=" + parts +
                ", hitPoints=" + hitPoints +
                '}';
    }
}

