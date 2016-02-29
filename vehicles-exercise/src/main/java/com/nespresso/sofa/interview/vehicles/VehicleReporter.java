package com.nespresso.sofa.interview.vehicles;

import java.text.DecimalFormat;
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

    public void emitOpenedDoor(int number) {
        if (number % 2 == 0) {
            builder.append("\\");
            newLine();
            return;
        } else {
            appendEmptySpace();
            builder.append("/");
            if (number == 3) {
                builder.append("_");
            } else
                appendEmptySpace();
        }

    }

    public void emitClosedDoor(int number) {
        if (number % 2 == 0) {
            builder.append("|");
            newLine();
            return;
        } else {
            appendEmptySpace();
            builder.append("|");
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
