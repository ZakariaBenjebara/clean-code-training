package com.nespresso.recruitment.gossip.media;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.Feedback;
import com.nespresso.recruitment.gossip.message.MessageBody;
import com.nespresso.recruitment.gossip.person.Person;

import java.util.Observable;
import java.util.Observer;

public class Channel implements Observer {

    private final Person source;

    private final Person receiver;

    public Channel(Person source, Person receiver) {
        this.source = source;
        this.receiver = receiver;
        linkObservers();
    }

    private void linkObservers() {
        source.addObserver(this);
        receiver.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        final Person sender = (Person) o;
        final MessageBody message = (MessageBody) arg;
        if (sender == source) {
            if (sender.isGentleMan())
                return;
            final Feedback feedback = receiver.receiveMessage(new Envelop(source, receiver, message));
            if (feedback.isAccepted()) {
                source.messageAccepted();
            }
        } else if (sender == receiver) {
            if (sender.isGentleMan()) {
                source.receiveMessage(new Envelop(receiver, source, message));
            }
        }
    }
}
