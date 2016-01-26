package com.nespresso.recruitment.gossip.person;

public enum Civility {

    GENTLEMAN("Sir"), MISTER("Mr"), DOCTOR("Dr"), AGENT("Agent"), PROFESSOR("Pr"), LADY("Lady"), NULL("");

    private final String prefix;

    Civility(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public static Civility fromString(final String civilityName) {
        if (civilityName == null)
            throw new IllegalArgumentException("Missing the name of civility");

        for (Civility civility : Civility.values()) {
            if (civility.getPrefix().equals(civilityName))
                return civility;
        }
        throw new IllegalStateException();
    }

    public static boolean isDoctor(final Civility civility) {
        return civility == DOCTOR;
    }

    public static boolean isGentleMan(final Civility civility) {
        return civility == GENTLEMAN;
    }
}
