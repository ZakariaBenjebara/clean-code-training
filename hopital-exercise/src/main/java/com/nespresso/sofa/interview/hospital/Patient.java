package com.nespresso.sofa.interview.hospital;

import java.util.Set;

final class Patient {

    private HealthStatus healthStatus;

    private Patient(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    void applyTreatments(Set<Treatment> treatments) {
        this.healthStatus = healthStatus.healWith(treatments);
    }

    void appendStatToReport(ReportAppendable appendable) {
        healthStatus.appendStatusToReport(appendable);
    }

    static final class Factory {

        public static Patient of(final HealthStatus healthStatus) {
            return new Patient(healthStatus);
        }

        private Factory() {}
    }
}
