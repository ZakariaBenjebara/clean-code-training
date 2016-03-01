package com.nespresso.sofa.interview.hospital;

import java.util.LinkedHashMap;
import java.util.Map;

final class QuarantineReporter implements Reporter<HealthStatus> {

    private static final String SEPARATOR = ":";

    private static final String EMPTY_SEPARATOR = " ";

    private final Map<HealthStatus, Integer> reporter;

    QuarantineReporter() {
        this.reporter = initReporter();
    }

    @Override
    public String report() {
        final StringBuilder builder = new StringBuilder();
        for (final Map.Entry<HealthStatus, Integer> entry : reporter.entrySet()) {
            builder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(EMPTY_SEPARATOR);
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    @Override
    public void append(final HealthStatus status) {
        if (status == null) {
            throw new IllegalArgumentException();
        }
        appendHealthStatusToReporter(status);
    }

    private static Map<HealthStatus, Integer> initReporter() {
        final Map<HealthStatus, Integer> reporter = new LinkedHashMap<>();
        for (final HealthStatus healthStatus : HealthStatus.values()) {
            reporter.put(healthStatus, 0);
        }
        return reporter;
    }

    private void appendHealthStatusToReporter(final HealthStatus healthStat) {
        if (reporter.containsKey(healthStat)) {
            final Integer value = reporter.get(healthStat);
            reporter.put(healthStat, value + 1);
        }
    }
}
