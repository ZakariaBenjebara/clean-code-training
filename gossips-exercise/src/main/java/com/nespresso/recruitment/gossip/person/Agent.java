package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;
import com.nespresso.recruitment.gossip.utils.MessageUtils;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.nespresso.recruitment.gossip.message.MessageBody.*;

class Agent extends Person {

    private final Set<MessageBody> incomingMessages = new LinkedHashSet<>();

    public Agent(String name, Civility civility) {
        super(name, civility);
    }

    @Override
    public void saveAsIncomingMessage(final Envelop envelop) {
        if (messageToSay.checkNotEmptyContent())
            messageToSay = EMPTY_MESSAGE;
        incomingMessages.add(envelop.body());
    }

    @Override
    public void messageAccepted() {

    }

    @Override
    public String ask() {
        return messageToSay.checkNotEmptyContent() ? messageToSay.content() : EMPTY_MESSAGE.content();
    }

    @Override
    public void onGossips() {
        if (!incomingMessages.isEmpty()) {
            messageToSay = new MessageBody(MessageUtils.joint(", ", incomingMessages));
            incomingMessages.clear();
        }
    }
}
