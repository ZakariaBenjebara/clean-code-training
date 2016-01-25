package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;
import com.nespresso.recruitment.gossip.utils.MessageUtils;

import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.nespresso.recruitment.gossip.message.MessageBody.EMPTY_MESSAGE;

class Doctor extends Person {

    private final Set<MessageBody> incomingMessages = new LinkedHashSet<>();

    private final Queue<MessageBody> outMessages = new ConcurrentLinkedQueue<>();

    public Doctor(String name, Civility civility) {
        super(name, civility);
    }

    @Override
    public void saveAsIncomingMessage(final Envelop envelop) {
        incomingMessages.add(envelop.body());
        outMessages.add(envelop.body());
    }

    @Override
    public void messageAccepted() {

    }

    @Override
    public String ask() {
        return MessageUtils.joint(", ", incomingMessages);
    }

    @Override
    public void onGossips() {
        if (!outMessages.isEmpty()) {
            messageToSay = outMessages.remove();
        } else {
            messageToSay = EMPTY_MESSAGE;
        }
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "incomingMessages=" + incomingMessages +
                ", outMessages=" + outMessages +
                '}';
    }
}
