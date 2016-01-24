package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;

public class Professor extends Person {

    private MessageBody incomingMessage = NULL_MESSAGE;

    public Professor(String name, Prefix prefix) {
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
        messageToSay = (incomingMessage.checkNotEmptyContent() == true) ? incomingMessage : NULL_MESSAGE;
    }

    @Override
    public String toString() {
        return "Mister{" + super.toString() +
                "incomingMessage=" + incomingMessage +
                '}';
    }
}
