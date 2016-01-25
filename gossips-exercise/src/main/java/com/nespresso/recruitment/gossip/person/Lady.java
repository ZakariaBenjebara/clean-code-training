package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;

import static com.nespresso.recruitment.gossip.message.MessageBody.EMPTY_MESSAGE;

class Lady extends Person {

    private Envelop incomingMessage = new Envelop(NULL_PERSON, NULL_PERSON, EMPTY_MESSAGE);

    public Lady(String name, Civility civility) {
        super(name, civility);
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
        if (incomingMessage.isFromDoctor()) {
            messageToSay = incomingMessage.body().checkNotEmptyContent() ? incomingMessage.body() : EMPTY_MESSAGE;
        } else {
            messageToSay = EMPTY_MESSAGE;
        }
    }
}
