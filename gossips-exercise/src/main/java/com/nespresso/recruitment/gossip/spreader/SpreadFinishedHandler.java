package com.nespresso.recruitment.gossip.spreader;


public interface SpreadFinishedHandler {

    void successor(SpreadFinishedHandler successor);

    void handle();
}
