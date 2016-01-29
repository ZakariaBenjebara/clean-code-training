package com.nespresso.recruitment.gossip.spreader;

import com.nespresso.recruitment.gossip.person.Person;

final class LadySpreader extends SpreadStrategy {

    public LadySpreader(Person person) {
        super(person);
    }

    @Override
    public void spread() {
        person.spreadMessage();
    }
}
