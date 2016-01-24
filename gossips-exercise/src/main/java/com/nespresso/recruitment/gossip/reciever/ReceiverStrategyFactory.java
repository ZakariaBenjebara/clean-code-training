package com.nespresso.recruitment.gossip.reciever;

import com.nespresso.recruitment.gossip.person.Person;
import com.nespresso.recruitment.gossip.person.Prefix;

public enum ReceiverStrategyFactory {
    INSTANCE;

    public ReceiverStrategy createReceiverForPersonByCivility(final Prefix prefix, final Person person) {
        switch (prefix) {
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
            case GENTLMAN:
                return new GentleReceiver(person);
            default:
                throw new IllegalStateException();
        }
    }

}
