//package com.nespresso.sofa.recruitment.navalbattles.battle;
//
//import com.nespresso.sofa.recruitment.navalbattles.batteau.Ship;
//import com.nespresso.sofa.recruitment.navalbattles.battle.part.Canon;
//import com.nespresso.sofa.recruitment.navalbattles.battle.part.Hull;
//import com.nespresso.sofa.recruitment.navalbattles.battle.part.Mast;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class BattleShip extends Ship {
//
//    private static final int CANNON_DAMAGE = 200;
//
//    private final Hull hull;
//
//    private final List<Canon> canons;
//
//    private final List<Mast> masts;
//
//    private double health = 0;
//
//    private Defender chain = null;
//
//    public BattleShip(int displacement, int mast, int canonNumber) {
//        super(displacement, mast, canonNumber);
//        this.canons = createCanons(canonNumber);
//        this.masts = createMasts(mast);
//        this.hull = createHullPart(displacement);
//        health = calculateShipHealth();
//    }
//
//    private double calculateShipHealth() {
//        double health = hull.health();
//        for (final Canon canon : canons) {
//            health += canon.health();
//        }
//        for (final Mast mast : masts) {
//            health += mast.health();
//        }
//        return health;
//    }
//
//    public double attack() {
//        int numberOfWorkedCanons = 0;
//        for (final Canon canon : canons) {
//            if (!canon.isDestroyed())
//                numberOfWorkedCanons++;
//        }
//        return numberOfWorkedCanons * CANNON_DAMAGE;
//    }
//
//    public void defence(final double damageAccepted) {
//        double damageTaken = damageAccepted;
//        canons.get(0).defendAgainst(damageAccepted);
//        health -= damageTaken;
//        if (health <= 0)
//            System.out.println("the ships is shunk");
//    }
//
//    private List<Mast> createMasts(final int valueOfMast) {
//        final List<Mast> masts = new LinkedList<>();
//        for (int i = 1; i <= valueOfMast; i++) {
//            final Mast mast = new Mast();
//            masts.add(mast);
//            if (chain != null) {
//                chain.successor(mast);
//            }
//            chain = mast;
//        }
//        return masts;
//    }
//
//    private  List<Canon> createCanons(final int canonNumber) {
//        final List<Canon> canons = new LinkedList<>();
//        for (int i = 1; i <= canonNumber; i++) {
//            final Canon canon = new Canon();
//            canons.add(canon);
//            if (chain != null) {
//                chain.successor(canon);
//            }
//            chain = canon;
//        }
//        return canons;
//    }
//
//    private Hull createHullPart(final int displacement) {
//        final Hull hull = new Hull(displacement);
//        chain.successor(hull);
//        return hull;
//    }
//
//    public double health() {
//        return health;
//    }
//}
