package com.nespresso.recruitment.gossip.spreader;

import com.nespresso.recruitment.gossip.person.Person;

final class GentleSpreader extends SpreadStrategy {

    public GentleSpreader(Person person) {
        super(person);
    }

    @Override
    public void spread() {
        person.spreadMessage();
    }
}
