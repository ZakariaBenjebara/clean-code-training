package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;

public class Gentle extends Person {

    private MessageBody incomingMessage = NULL_MESSAGE;

    public Gentle(String name, Prefix prefix) {
        super(name, prefix);
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
        return incomingMessage.content();
    }

    @Override
    public void onGossips() {
        final String reverse = new StringBuilder(incomingMessage.content()).reverse().toString();
        messageToSay = incomingMessage.checkNotEmptyContent() ? new MessageBody(reverse) : NULL_MESSAGE;
        incomingMessage = NULL_MESSAGE;
    }

    @Override
    public String toString() {
        return "Gentle{" +
                "incomingMessage=" + incomingMessage +
                '}';
    }
}
