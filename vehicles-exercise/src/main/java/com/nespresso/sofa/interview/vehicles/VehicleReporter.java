package com.nespresso.sofa.interview.vehicles;

import java.util.Locale;

public final class VehicleReporter {

    private final StringBuilder builder = new StringBuilder();

    public void emitDoorsOk() {
        builder.append("DOORS OK");
        appendSeparator();
        appendEmptySpace();
        moving();
    }

    public void emitDoorsKo() {
        builder.append("DOORS KO");
        appendSeparator();
        appendEmptySpace();
        blocked();
        emitVehicleHead();
    }

    public void emitConsummation(String vehicle, float consummation) {
        builder.append("The "+vehicle+" will consume "+String.format(Locale.ENGLISH, "%.2f", consummation) +" L ");
    }

    public void emitOpenedDoor(int number) {
        emitDoor(number, false);
    }

    public void emitClosedDoor(int number) {
        emitDoor(number, true);
    }

    private void moving() {
        builder.append("MOVING.");
        appendEmptySpace();
    }

    private void blocked() {
        builder.append("BLOCKED");
        appendEmptySpace();
        newLine();
    }

    private void appendSeparator() {
        builder.append(",");
    }

    private void appendEmptySpace() {
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
            appendEmptySpace();
            builder.append(closed ? "|" : "/");
            if (number == 3) {
                builder.append("_");
            } else
                appendEmptySpace();
        }
    }

    private void emitVehicleHead() {
        appendEmptySpace();
        appendEmptySpace();
        builder.append("_");
        newLine();
    }

    public final String report() {
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
