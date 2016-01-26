package com.sqli.nespresso.train.state;

public class CargoState {

    enum State {
        EMPTY,
        FILLED
    }

    private State state = State.EMPTY;

    public boolean change() {
        if (state == State.EMPTY) {
            state = State.FILLED;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return state == State.EMPTY;
    }
}
