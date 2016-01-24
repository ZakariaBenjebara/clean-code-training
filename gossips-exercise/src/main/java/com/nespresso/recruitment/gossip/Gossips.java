package com.nespresso.recruitment.gossip;

import com.nespresso.recruitment.gossip.handler.GossipsHandler;
import com.nespresso.recruitment.gossip.media.Channel;
import com.nespresso.recruitment.gossip.message.Envelop;
import com.nespresso.recruitment.gossip.message.MessageBody;
import com.nespresso.recruitment.gossip.person.Person;
import com.nespresso.recruitment.gossip.person.PersonFactory;
import com.nespresso.recruitment.gossip.person.Prefix;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Gossips {

    private final Map<String, Person> persons;

    private final Set<Channel> channels;

    private final GossipsHandler<Person> gossipsHandler;

    private CommandMemento commandMemento;

    public Gossips(final String... namesOfPersons) {
        this.persons = createPersons(namesOfPersons);
        this.channels = new HashSet<>();
        this.gossipsHandler = new GossipsHandler(persons.values());
    }

    private Map<String, Person> createPersons(final String... namesOfPersons) {
        final Map<String, Person> persons = new LinkedHashMap<>();
        for (final String person : namesOfPersons) {
            final String[] splitter = person.split(" ");
            final Prefix prefix = Prefix.fromString(splitter[0]);
            final String name = splitter[1];
            persons.put(name, PersonFactory.INSTANCE.createPerson(name, prefix));
        }
        return persons;
    }

    public Gossips say(final String hello) {
        save(new CommandMemento(CommandMemento.Type.SAY, hello));
        return this;
    }

    public Gossips from(final String person) {
        save(new CommandMemento(CommandMemento.Type.FROM, person));
        return this;
    }

    public Gossips to(final String person) {
        final CommandMemento.Type typeOfCommand = commandMemento.type;
        switch (typeOfCommand) {
            case FROM:
                final Person from = persons.get(commandMemento.command);
                final Person to = persons.get(person);
                final Channel channel = new Channel(from, to);
                channels.add(channel);
                break;
            case SAY:
                final Person asked = persons.get(person);
                asked.saveAsIncomingMessage(new Envelop(null, null,new MessageBody(commandMemento.command)));
                break;
            default:
                throw new IllegalStateException();
        }
        return this;
    }

    public String ask(final String person) {
        final Person asked = persons.get(person);
        return asked.ask() == null ? "" : asked.ask();
    }

    private void save(final CommandMemento commandMemento) {
        this.commandMemento = commandMemento;
    }

    public void spread() {
        gossipsHandler.fireEvent();
        for (final String personName : persons.keySet()) {
            final Person person = persons.get(personName);
            person.spread();
        }
    }

    private static class CommandMemento {

        enum Type {
            SAY, FROM
        }

        private final Type type;

        private final String command;

        public CommandMemento(Type type, String command) {
            this.type = type;
            this.command = command;
        }
    }
}
