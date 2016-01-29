package com.nespresso.recruitment.gossip.receiver;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.Feedback;
import com.nespresso.recruitment.gossip.person.Person;

final class MisterReceiver extends ReceiverStrategy {

    public MisterReceiver(Person person) {
        super(person);
    }

    @Override
    public Feedback receive(final Envelop envelop) {

        if (envelop.body().checkNotEmptyContent()) {
            pushToIncomingMessage(envelop);
        }

        return new Feedback().accepted();
    }

    private void pushToIncomingMessage(final Envelop envelop) {
        person.saveAsIncomingMessage(envelop);
    }
}
