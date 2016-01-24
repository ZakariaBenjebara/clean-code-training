package com.nespresso.recruitment.gossip.reciever;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.Feedback;
import com.nespresso.recruitment.gossip.person.Person;

final class MisterReceiver extends ReceiverStrategy {

    public MisterReceiver(Person person) {
        super(person);
    }

    @Override
    public Feedback receive(final Envelop envelop) {
        if (envelop == null)
            return new Feedback().refused();

        if (person.hasAlreadyGossips()) {
            return new Feedback().refused();
        }

        if (envelop.body().checkNotEmptyContent())
            pushToIncomingMessages(envelop);

        return new Feedback().accepted();
    }

    private void pushToIncomingMessages(final Envelop envelop) {
        person.saveAsIncomingMessage(envelop);
    }
}
