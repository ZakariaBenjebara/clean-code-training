package com.nespresso.recruitment.gossip.handler;

import java.util.Collection;

public class GossipsHandler<T extends GossipsListener> {

    private final Collection<T> listeners;

    public GossipsHandler(final Collection<T> listeners) {
        this.listeners = listeners;
    }

    public void fireEvent() {
        for (final GossipsListener listener : listeners) {
            listener.onGossips();
        }
    }
}
