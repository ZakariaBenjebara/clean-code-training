package com.nespresso.recruitment.gossip.spreader;

import com.nespresso.recruitment.gossip.person.Person;
import com.nespresso.recruitment.gossip.person.Prefix;

public enum SpreadStrategyFactory {
    INSTANCE;

    public SpreadStrategy createSpreadStrategyForPerson(final Prefix prefix, final Person person) {
        switch (prefix) {
            case MISTER:
                return new MisterSpreader(person);
            case DOCTOR:
                return new DoctorSpreader(person);
            case AGENT:
                return new AgentSpreader(person);
            case PROFESSOR:
                return new ProfessorSpreader(person);
            case LADY:
                return new LadySpreader(person);
            case GENTLMAN:
                return new GentleSpreader(person);
            default:
                throw new IllegalStateException();
        }
    }

}
