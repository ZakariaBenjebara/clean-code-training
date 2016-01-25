package com.nespresso.recruitment.gossip.spreader;

import com.nespresso.recruitment.gossip.person.Civility;
import com.nespresso.recruitment.gossip.person.Person;

public enum SpreadStrategyFactory {
    INSTANCE;

    public SpreadStrategy createSpreadStrategyForPerson(final Civility civility, final Person person) {
        switch (civility) {
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
            case GENTLEMAN:
                return new GentleSpreader(person);
            case NULL:
                return null;
            default:
                throw new IllegalStateException();
        }
    }

}
