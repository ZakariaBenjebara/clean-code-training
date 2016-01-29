package com.nespresso.recruitment.gossip.spreader;

import com.nespresso.recruitment.gossip.person.Person;

final class DoctorSpreader extends SpreadStrategy {

    public DoctorSpreader(Person person) {
        super(person);
    }

    @Override
    public void spread() {
        person.spreadMessage();
    }
}
