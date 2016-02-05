package com.nespresso.sofa.recruitment.navalbattles.battle;

public final class Damage {

    public static final Damage NULL_DAMAGE = new Damage(0);

    private final int value;

    public Damage(int value) {
        this.value = value;
    }

    public boolean canDoDamage() {
        return value > 0;
    }

    public static Damage doDestroy(final Damage damage, final int hitPoint) {
        return new Damage(damage.value - hitPoint);
    }

    public static Damage addDamage(final Damage source, final Damage additional) {
        return new Damage(source.value + additional.value);
    }

    public static int absDamage(final Damage source) {
        return Math.abs(source.value);
    }

    public static int signature(final Damage damage) {
        if (damage.value > 0)
            return 1;
        else if (damage.value < 0)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Damage{" +
                "value=" + value +
                '}';
    }
}
