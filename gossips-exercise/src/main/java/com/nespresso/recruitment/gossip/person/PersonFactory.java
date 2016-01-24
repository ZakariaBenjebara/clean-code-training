package com.nespresso.recruitment.gossip.person;

public enum  PersonFactory {
    INSTANCE;

    public Person createPerson(final String name, final Prefix prefix) {
        switch (prefix) {
            case MISTER:
                return new Mister(name, prefix);
            case DOCTOR:
                return new Doctor(name, prefix);
            case AGENT:
                return new Agent(name, prefix);
            case PROFESSOR:
                return new Professor(name, prefix);
            case LADY:
                return new Lady(name, prefix);
            case GENTLMAN:
                return new Gentle(name, prefix);

            default:
                throw new IllegalStateException();
        }
    }
}
