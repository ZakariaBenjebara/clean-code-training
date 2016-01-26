package com.sqli.nespresso.train.writer;

import com.sqli.nespresso.train.wagon.Head;

final class HeadWriter extends WagonWriterTemplate<Head, String> {

    @Override
    protected String shape(final Head head) {
        return "HHHH";
    }
}
