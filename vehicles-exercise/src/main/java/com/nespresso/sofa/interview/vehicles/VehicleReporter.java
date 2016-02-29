package com.nespresso.sofa.interview.vehicles;

import java.util.Locale;

public final class VehicleReporter {

    private final StringBuilder builder = new StringBuilder();

    public void emitDoorsOk() {
        builder.append("DOORS OK");
        separator();
        emptySpace();
        moving();
    }

    public void emitDoorsKo() {
        builder.append("DOORS KO");
        separator();
        emptySpace();
        blocked();
        head();
    }

    public void emitConsummation(final String vehicle, float consummation) {
        builder.append("The "+ vehicle +" will consume "+ String.format(Locale.ENGLISH, "%.2f", consummation) +" L ");
    }

    public void emitOpenedDoor(int number) {
        emitDoor(number, false);
    }

    public void emitClosedDoor(int number) {
        emitDoor(number, true);
    }

    private void moving() {
        builder.append("MOVING.");
        emptySpace();
    }

    private void blocked() {
        builder.append("BLOCKED");
        emptySpace();
        newLine();
    }

    private void separator() {
        builder.append(",");
    }

    private void emptySpace() {
        builder.append(" ");
    }

    private void newLine() {
        builder.append("\n");
    }

    private void emitDoor(int number, boolean closed) {
        if (number % 2 == 0) {
            builder.append(closed ? "|" : "\\");
            newLine();
        } else {
            emptySpace();
            builder.append(closed ? "|" : "/");
            if (number == 3) builder.append("_");
            else emptySpace();
        }
    }

    private void head() {
        emptySpace();
        emptySpace();
        builder.append("_");
        newLine();
    }

    public final String report() {
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
