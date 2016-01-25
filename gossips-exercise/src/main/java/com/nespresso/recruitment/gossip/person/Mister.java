package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.nespresso.recruitment.gossip.message.MessageBody.*;

public class Mister extends Person {

    private final Queue<MessageBody> incomingMessages = new ConcurrentLinkedQueue<>();

    public Mister(String name, Civility civility) {
        super(name, civility);
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
        return messageToSay.checkNotEmptyContent() ? messageToSay.content()
                : EMPTY_MESSAGE.content();
    }

    @Override
    public void onGossips() {
        messageToSay = incomingMessages.isEmpty() ? EMPTY_MESSAGE : incomingMessages.remove();
        incomingMessages.clear();
    }

    @Override
    public String toString() {
        return "Mister{" + super.toString() +
                "incomingMessages=" + incomingMessages +
                '}';
    }
}
