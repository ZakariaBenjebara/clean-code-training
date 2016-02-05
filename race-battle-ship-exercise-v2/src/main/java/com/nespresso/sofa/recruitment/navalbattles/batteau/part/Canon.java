package com.nespresso.sofa.recruitment.navalbattles.batteau.part;

import com.nespresso.sofa.recruitment.navalbattles.battle.Damage;
import com.nespresso.sofa.recruitment.navalbattles.battle.DefencePriority;

public class Canon extends AbstractPart {

    private static final int CANON_HIT_DAMAGE = 200;

    public Canon() {
        hitPoints = 100;
    }

    @Override
    public Damage damagePower(Damage damage) {
        return Damage.addDamage(damage, new Damage(CANON_HIT_DAMAGE));
    }

    @Override
    public int defencePriority() {
        return DefencePriority.MIDDLE.value();
    }
}
