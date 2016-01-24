/*
 * Copyright (C) 2015 ZGeeks, Inc.
 */
package com.nespresso.recruitment.gossip.utils;

import com.nespresso.recruitment.gossip.message.MessageBody;

import java.util.Collection;

/**
 * nespresso-training
 *
 * @author Zakaria BENJEBARA.
 * @date 21/01/16
 * @time 01:00
 */
public final class MessageUtils {

    public static String joint(final String separator, final Collection<MessageBody> messages) {
        final StringBuilder builder = new StringBuilder();

        for (final MessageBody messageBody : messages) {
            if (builder.length() != 0)
                builder.append(separator);
            builder.append(messageBody.content());
        }

        return builder.toString();
    }

    private MessageUtils() {}
}
