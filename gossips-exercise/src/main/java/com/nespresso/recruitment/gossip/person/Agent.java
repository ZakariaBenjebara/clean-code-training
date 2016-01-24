package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;
import com.nespresso.recruitment.gossip.utils.MessageUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class Agent extends Person {

    private final Set<MessageBody> incomingMessages = new LinkedHashSet<>();

    private boolean canCleanMessages = false;

    public Agent(String name, Prefix prefix) {
        super(name, prefix);
    }

    @Override
    public void saveAsIncomingMessage(final Envelop envelop) {
        incomingMessages.add(envelop.body());
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
        if (!incomingMessages.isEmpty())
            incomingMessages.clear();
    }

    @Override
    public String toString() {
        return "Agent{" +
                "incomingMessages=" + incomingMessages +
                ", canCleanMessages=" + canCleanMessages +
                '}';
    }
}
