package com.nespresso.sofa.recruitement.labirynth;

import java.util.Deque;

public final class WalkerFollower {

    private WalkerFollower() {
    }

    public static String readSensors(final Deque<AbstractGate> abstractGates) {
        if (abstractGates == null) {
            throw new NullPointerException();
        }

        final StringBuilder builder = new StringBuilder();
        for (AbstractGate abstractGate : abstractGates) {
            if (abstractGate instanceof SensorGate) {
                SensorGate sensor = (SensorGate) abstractGate;
                builder.append(sensor.print());
                builder.append(";");
            }
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
