package com.nespresso.recruitment.gossip.spreader;

import com.nespresso.recruitment.gossip.person.Person;

public abstract class SpreadStrategy {

    protected final Person person;

    public SpreadStrategy(Person person) {
        this.person = person;
    }

    public abstract void spread();

}
