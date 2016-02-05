package com.nespresso.sofa.recruitment.navalbattles.batteau.part;

import com.nespresso.sofa.recruitment.navalbattles.battle.Damage;

public abstract class AbstractPart implements Comparable<AbstractPart> {

    protected int hitPoints = 0;

    public Damage absorb(Damage damage) {
        Damage absorbed = Damage.doDestroy(damage, hitPoints);
        switch (Damage.signature(absorbed)) {
            case 1:
                hitPoints = 0;
                break;
            case -1:
                hitPoints = Damage.absDamage(absorbed);
                absorbed = Damage.NULL_DAMAGE;
                break;
            case 0:
                hitPoints = 0;
                absorbed = Damage.NULL_DAMAGE;
                break;
        }
        return absorbed;
    }

    public int adoptHitPoints(int shipHitPoints) {
        shipHitPoints += hitPoints;
        return shipHitPoints;
    }

    @Override
    public int compareTo(final AbstractPart that) {
        if (defencePriority() < that.defencePriority())
            return -1;
        else if (defencePriority() > that.defencePriority())
            return 1;
        return 0;
    }

    public abstract Damage damagePower(Damage damage);

    public abstract int defencePriority();

    @Override
    public String toString() {
        return "AbstractPart{" +
                "hitPoints=" + hitPoints +
                '}';
    }
}
