package com.nespresso.recruitment.gossip.receiver;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.Feedback;
import com.nespresso.recruitment.gossip.person.Person;

public abstract class ReceiverStrategy {

    protected final Person person;

    public ReceiverStrategy(Person person) {
        this.person = person;
    }

    public abstract Feedback receive(Envelop envelop);
}
