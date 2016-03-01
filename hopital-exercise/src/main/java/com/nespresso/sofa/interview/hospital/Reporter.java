package com.nespresso.sofa.interview.hospital;

interface Reporter<T> extends ReportAppendable<T> {
    String report();
}
