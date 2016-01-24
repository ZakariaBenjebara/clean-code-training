package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;

public class Lady extends Person {

    private Envelop incomingMessage = new Envelop(NULL_PERSON , NULL_PERSON, NULL_MESSAGE);

    public Lady(String name, Prefix prefix) {
        super(name, prefix);
    }

    @Override
    public void saveAsIncomingMessage(final Envelop envelop) {
            incomingMessage = envelop;
    }

    @Override
    public void messageAccepted() {
    }

    @Override
    public String ask() {
        return incomingMessage.body().content();
    }

    @Override
    public void onGossips() {
        if (Person.isDoctor(incomingMessage.from())) {
            messageToSay = incomingMessage.body().checkNotEmptyContent()
                    ? incomingMessage.body() : NULL_MESSAGE;
        } else {
            messageToSay = NULL_MESSAGE;
        }
    }

}
