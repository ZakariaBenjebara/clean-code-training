package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;

import static com.nespresso.recruitment.gossip.message.MessageBody.EMPTY_MESSAGE;

class Professor extends Person {

    private MessageBody incomingMessage = EMPTY_MESSAGE;

    public Professor(String name, Civility civility) {
        super(name, civility);
    }

    @Override
    public void saveAsIncomingMessage(final Envelop envelop) {
        incomingMessage = envelop.body();
    }

    @Override
    public void messageAccepted() {
    }

    @Override
    public String ask() {
        return messageToSay.content();
    }

    @Override
    public void onGossips() {
        messageToSay = incomingMessage.checkNotEmptyContent() ? incomingMessage : EMPTY_MESSAGE;
    }
}
