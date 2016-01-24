package com.nespresso.recruitment.gossip.person;

import com.nespresso.recruitment.gossip.handler.GossipsListener;
import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.Feedback;
import com.nespresso.recruitment.gossip.message.MessageBody;
import com.nespresso.recruitment.gossip.reciever.ReceiverStrategy;
import com.nespresso.recruitment.gossip.reciever.ReceiverStrategyFactory;
import com.nespresso.recruitment.gossip.spreader.SpreadStrategy;
import com.nespresso.recruitment.gossip.spreader.SpreadStrategyFactory;

import java.util.Observable;

public abstract class Person extends Observable implements GossipsListener {

    protected final static MessageBody NULL_MESSAGE = new MessageBody("");

    private final Prefix prefix;

    private final String name;

    private final SpreadStrategy spreadStrategy;

    private final ReceiverStrategy receiverStrategy;

    protected MessageBody messageToSay = NULL_MESSAGE;

    protected boolean hasGossips = false;

    protected Person(final String name, final Prefix prefix) {
        this.name = name;
        this.prefix = prefix;
        this.spreadStrategy = SpreadStrategyFactory.INSTANCE.createSpreadStrategyForPerson(prefix, this);
        this.receiverStrategy = ReceiverStrategyFactory.INSTANCE.createReceiverForPersonByCivility(prefix, this);
    }

    public Feedback receiveMessage(final Envelop envelop) {
        if (envelop == null)
            return new Feedback().refused();

        if (envelop.isTheCorrectDestination(this)) {
            return receiverStrategy.receive(envelop);
        }
        return new Feedback().refused();
    }

    public abstract void messageAccepted();

    public boolean hasAlreadyGossips() {
        return hasGossips;
    }

    public synchronized void spread() {
        spreadStrategy.spread();
    }

    public void spreadMessage() {
        setChanged();
        notifyObservers(messageToSay);
    }

    public static boolean isDoctor(final Person person) {
        if (person == null)
            return false;
        return Prefix.isDoctor(person.prefix);
    }

    public static boolean isGentleMan(final Person person) {
        if (person == null)
            return false;
        return Prefix.isGentleMan(person.prefix);
    }


    public abstract void saveAsIncomingMessage(final Envelop envelop);

    public abstract String ask();

    public static final Person NULL_PERSON = new Person("", Prefix.AGENT) {

        @Override
        public void messageAccepted() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void saveAsIncomingMessage(Envelop envelop) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String ask() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void onGossips() {
            throw new UnsupportedOperationException();
        }
    };

}
