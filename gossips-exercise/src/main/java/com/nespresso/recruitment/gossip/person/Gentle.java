package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;

import static com.nespresso.recruitment.gossip.message.MessageBody.*;

class Gentle extends Person {

    private MessageBody incomingMessage = EMPTY_MESSAGE;

    private MessageBody currentMessage = EMPTY_MESSAGE;

    public Gentle(String name, Civility civility) {
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
        return currentMessage.content();
    }

    @Override
    public void onGossips() {
        final String reverse = new StringBuilder(incomingMessage.content()).reverse().toString();
        messageToSay = incomingMessage.checkNotEmptyContent() ? new MessageBody(reverse) : EMPTY_MESSAGE;
        currentMessage = incomingMessage;
        incomingMessage = EMPTY_MESSAGE;
    }

    @Override
    public String toString() {
        return "Gentle{" +
                "incomingMessage=" + incomingMessage +
                '}';
    }
}
