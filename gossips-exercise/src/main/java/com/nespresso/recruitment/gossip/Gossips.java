package com.nespresso.recruitment.gossip;

import com.nespresso.recruitment.gossip.handler.GossipsHandler;
import com.nespresso.recruitment.gossip.media.Channel;
import com.nespresso.recruitment.gossip.message.MessageBody;
import com.nespresso.recruitment.gossip.person.Civility;
import com.nespresso.recruitment.gossip.person.Person;
import com.nespresso.recruitment.gossip.person.PersonFactory;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Gossips {

    private final Map<String, Person> persons;

    private final Set<Channel> channels;

    private final GossipsHandler<Person> gossipsHandler;

    private final PersonLinker personLinker;

    private final MessageBuilder messageBuilder;

    public Gossips(final String... namesOfPersons) {
        this.persons = createPersons(namesOfPersons);
        this.channels = new HashSet<>();
        this.gossipsHandler = new GossipsHandler(persons.values());
        this.personLinker = new PersonLinker(this);
        this.messageBuilder = new MessageBuilder(this);
    }

    private Map<String, Person> createPersons(final String... namesOfPersons) {
        final Map<String, Person> persons = new LinkedHashMap<>();
        for (final String person : namesOfPersons) {
            final String[] splitter = person.split(" ");
            final Civility prefix = Civility.fromString(splitter[0]);
            final String name = splitter[1];
            persons.put(name, PersonFactory.INSTANCE.createPerson(name, prefix));
        }
        return persons;
    }

    public MessageBuilder say(final String message) {
        messageBuilder.say(message);
        return messageBuilder;
    }

    public PersonLinker from(final String person) {
        personLinker.from(person);
        return personLinker;
    }

    public String ask(final String person) {
        final Person asked = persons.get(person);
        return asked.ask() == null ? "" : asked.ask();
    }

    public void spread() {
        for (final String personName : persons.keySet()) {
            final Person person = persons.get(personName);
            person.spread();
        }
        gossipsHandler.fireEvent();
    }

    static final class PersonLinker {

        private final Gossips gossips;

        private String fromNameOfPerson;

        PersonLinker(Gossips gossips) {
            this.gossips = gossips;
        }

        PersonLinker from(final String nameOfPerson) {
            this.fromNameOfPerson = nameOfPerson;
            return this;
        }

        Gossips to(final String nameOfPerson) {
            final Person from = gossips.persons.get(fromNameOfPerson);
            final Person to = gossips.persons.get(nameOfPerson);
            final Channel channel = new Channel(from, to);
            gossips.channels.add(channel);
            return gossips;
        }
    }

    static final class MessageBuilder {

        private final Gossips gossips;

        private String messageToSay;

        MessageBuilder(Gossips gossips) {
            this.gossips = gossips;
        }

        MessageBuilder say(final String messageToSay) {
            this.messageToSay = messageToSay;
            return this;
        }

        Gossips to(final String nameOfPerson) {
            final Person to = gossips.persons.get(nameOfPerson);
            to.messageToSay(new MessageBody(messageToSay));
            return gossips;
        }
    }

}
