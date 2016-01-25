package com.nespresso.recruitment.gossip.message;

import com.nespresso.recruitment.gossip.person.Person;

public class Envelop {

    private final Person from;

    private final Person destination;

    private final MessageBody messageBody;

    public static final Envelop EMPTY_ENVELOP = new Envelop(Person.NULL_PERSON, Person.NULL_PERSON, MessageBody.EMPTY_MESSAGE);

    public Envelop(Person from, Person destination, MessageBody messageBody) {
        this.from = from;
        this.destination = destination;
        this.messageBody = messageBody;
    }

    public boolean isTheCorrectDestination(final Person person) {
        return person.equals(destination);
    }

    public MessageBody body() {
        return messageBody;
    }

    public Person from() {
        return from;
    }

    public boolean isFromDoctor() {
        return from.isDoctor();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Envelop{");
        sb.append("destination=").append(destination);
        sb.append(", messageBody=").append(messageBody);
        sb.append('}');
        return sb.toString();
    }
}
