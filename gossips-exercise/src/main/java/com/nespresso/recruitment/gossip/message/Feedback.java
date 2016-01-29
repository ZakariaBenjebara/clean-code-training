package com.nespresso.recruitment.gossip.message;


public class Feedback {

    enum State {
        ACCEPTED, REFUSED
    }

    private State state = State.ACCEPTED;

    public Feedback accepted() {
        state = State.ACCEPTED;
        return this;
    }

    public Feedback refused() {
        state = State.REFUSED;
        return this;
    }

    public boolean isAccepted() {
        return state == State.ACCEPTED;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feedback{");
        sb.append("state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}
