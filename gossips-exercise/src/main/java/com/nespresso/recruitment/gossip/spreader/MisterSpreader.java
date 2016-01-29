package com.nespresso.recruitment.gossip.spreader;

import com.nespresso.recruitment.gossip.person.Person;

final class MisterSpreader extends SpreadStrategy {

    public MisterSpreader(Person person) {
        super(person);
    }

    @Override
    public void spread() {
        person.spreadMessage();
    }
}
