package com.nespresso.recruitment.gossip.reciever;

import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.Feedback;
import com.nespresso.recruitment.gossip.person.Person;

final class ProfessorReceiver extends ReceiverStrategy {

    private int spreadCounter = 3;

    public ProfessorReceiver(Person person) {
        super(person);
    }

    @Override
    public Feedback receive(final Envelop envelop) {
        if (envelop == null)
            return new Feedback().refused();

        System.out.println("Message received " + envelop +" counter "+spreadCounter);

        if (spreadCounter == 3) {
            pushToIncomingMessages(envelop);
            spreadCounter = 1;
        }
        spreadCounter++;

        return new Feedback().accepted();
    }

    private void pushToIncomingMessages(final Envelop envelop) {
        person.saveAsIncomingMessage(envelop);
    }
}
