package com.nespresso.recruitment.gossip.person;

public enum Prefix {

    GENTLMAN("Sir") ,MISTER("Mr"), DOCTOR("Dr"), AGENT("Agent"), PROFESSOR("Pr"), LADY("Lady"), NULL("");

    private final String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public static Prefix fromString(final String value) {
        if (value == null)
            throw new IllegalArgumentException("Missing the withPrefix");

        for (Prefix prefix : Prefix.values()) {
            if (prefix.getPrefix().equals(value))
                return prefix;
        }
        throw new IllegalStateException();
    }

    public static boolean isDoctor(final Prefix prefix) {
        return prefix == DOCTOR;
    }

    public static boolean isGentleMan(final Prefix prefix) {
        return prefix == GENTLMAN;
    }

}
