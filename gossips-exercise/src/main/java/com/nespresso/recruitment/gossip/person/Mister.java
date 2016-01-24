package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Mister extends Person {

    private final Queue<MessageBody> incomingMessages = new ConcurrentLinkedQueue<>();

    public Mister(String name, Prefix prefix) {
        super(name, prefix);
    }

    @Override
    public void saveAsIncomingMessage(Envelop envelop) {
        incomingMessages.add(envelop.body());
    }

    @Override
    public void messageAccepted() {
    }

    @Override
    public String ask() {
        return incomingMessages.isEmpty() ? NULL_MESSAGE.content()
                : incomingMessages.element().content();
    }

    @Override
    public void onGossips() {
        messageToSay = incomingMessages.isEmpty() ? NULL_MESSAGE : incomingMessages.remove();
    }

    @Override
    public String toString() {
        return "Mister{" + super.toString() +
                "incomingMessages=" + incomingMessages +
                '}';
    }
}
