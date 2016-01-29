package com.nespresso.recruitment.gossip.receiver;

import com.nespresso.recruitment.gossip.person.Civility;
import com.nespresso.recruitment.gossip.person.Person;

public enum ReceiverStrategyFactory {
    INSTANCE;

    public ReceiverStrategy createReceiverForPersonByCivility(final Civility civility, final Person person) {
        switch (civility) {
            case MISTER:
                return new MisterReceiver(person);
            case DOCTOR:
                return new DoctorReceiver(person);
            case AGENT:
                return new AgentReceiver(person);
            case PROFESSOR:
                return new ProfessorReceiver(person);
            case LADY:
                return new LadyReceiver(person);
            case GENTLEMAN:
                return new GentleReceiver(person);
            case NULL:
                return null;
            default:
                throw new IllegalStateException();
        }
    }

}
