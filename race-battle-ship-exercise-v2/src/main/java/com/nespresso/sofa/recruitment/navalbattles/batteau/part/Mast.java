package com.nespresso.sofa.recruitment.navalbattles.batteau.part;

import com.nespresso.sofa.recruitment.navalbattles.battle.Damage;
import com.nespresso.sofa.recruitment.navalbattles.battle.DefencePriority;

public class Mast extends AbstractPart {

    public Mast() {
        hitPoints = 1000;
    }

    @Override
    public Damage damagePower(Damage damage) {
        return Damage.addDamage(damage, Damage.NULL_DAMAGE);
    }

    @Override
    public int defencePriority() {
        return DefencePriority.LOWEST.value();
    }
}
