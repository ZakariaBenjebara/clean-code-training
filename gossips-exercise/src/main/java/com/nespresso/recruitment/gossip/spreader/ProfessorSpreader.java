package com.nespresso.recruitment.gossip.spreader;

import com.nespresso.recruitment.gossip.person.Person;

final class ProfessorSpreader extends SpreadStrategy {

    private int spreadCounter = 1;

    public ProfessorSpreader(Person person) {
        super(person);
    }

    @Override
    public void spread() {
        if (spreadCounter == 3) {
            person.spreadMessage();
            spreadCounter = 1;
        }
        spreadCounter++;
    }
}
