package com.nespresso.recruitment.gossip.receiver;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.Feedback;
import com.nespresso.recruitment.gossip.person.Person;

final class LadyReceiver extends ReceiverStrategy {

    public LadyReceiver(Person person) {
        super(person);
    }

    @Override
    public Feedback receive(final Envelop envelop) {
        if (!envelop.body().checkNotEmptyContent())
            return new Feedback().refused();

        pushToIncomingMessage(envelop);
        return new Feedback().accepted();
    }

    private void pushToIncomingMessage(final Envelop envelop) {
        person.saveAsIncomingMessage(envelop);
    }
}
