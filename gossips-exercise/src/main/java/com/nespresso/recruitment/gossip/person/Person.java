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

import static com.nespresso.recruitment.gossip.message.MessageBody.*;

public abstract class Person extends Observable implements GossipsListener {

    private final Civility civility;

    private final String name;

    private final SpreadStrategy spreadStrategy;

    private final ReceiverStrategy receiverStrategy;

    protected MessageBody messageToSay = EMPTY_MESSAGE;

    protected boolean hasGossips = false;

    protected Person(final String name, final Civility civility) {
        this.name = name;
        this.civility = civility;
        this.spreadStrategy = SpreadStrategyFactory.INSTANCE.createSpreadStrategyForPerson(civility, this);
        this.receiverStrategy = ReceiverStrategyFactory.INSTANCE.createReceiverForPersonByCivility(civility, this);
    }

    public Feedback receiveMessage(final Envelop envelop) {
        if (envelop == null)
            return new Feedback().refused();

        if (envelop.isTheCorrectDestination(this)) {
            return receiverStrategy.receive(envelop);
        }
        return new Feedback().refused();
    }

    public void messageToSay(MessageBody messageToSay) {
        this.messageToSay = messageToSay;
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

    public boolean isDoctor() {
        return Civility.isDoctor(this.civility);
    }

    public boolean isGentleMan() {
        return Civility.isGentleMan(this.civility);
    }

    public abstract void saveAsIncomingMessage(final Envelop envelop);

    public abstract String ask();

    public static final Person NULL_PERSON = new Person("", Civility.NULL) {

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
