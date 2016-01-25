package com.nespresso.recruitment.gossip.person;

public enum  PersonFactory {
    INSTANCE;

    public Person createPerson(final String name, final Civility civility) {
        switch (civility) {
            case MISTER:
                return new Mister(name, civility);
            case DOCTOR:
                return new Doctor(name, civility);
            case AGENT:
                return new Agent(name, civility);
            case PROFESSOR:
                return new Professor(name, civility);
            case LADY:
                return new Lady(name, civility);
            case GENTLEMAN:
                return new Gentle(name, civility);
            case NULL:
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
