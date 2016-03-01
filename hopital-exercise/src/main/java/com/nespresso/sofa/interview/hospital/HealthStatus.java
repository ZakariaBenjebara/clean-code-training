package com.nespresso.sofa.interview.hospital;

import java.util.Collection;

import static com.nespresso.sofa.interview.hospital.Treatment.*;

enum HealthStatus {

    FEVER("F") {
        @Override
        protected HealthStatus apply(final Collection<Treatment> treatments) {
            if (treatments.contains(PARACETAMOL) || treatments.contains(ASPIRINE))
                return HEALTHY;
            return this;
        }
    },
    HEALTHY("H") {
        @Override
        protected HealthStatus apply(final Collection<Treatment> treatments) {
            if (treatments.contains(ANTIBIOTIC) && treatments.contains(INSULINE))
                return FEVER;
            return this;
        }
    },
    DIABETICS("D") {
        @Override
        protected HealthStatus apply(final Collection<Treatment> treatments) {
            if (!treatments.contains(INSULINE))
                return DEAD;
            return this;
        }
    },
    TUBERCULOSIS("T") {
        @Override
        protected HealthStatus apply(final Collection<Treatment> treatments) {
            if (treatments.contains(ANTIBIOTIC))
                return HEALTHY;
            return this;
        }
    },
    DEAD("X") {
        @Override
        protected HealthStatus apply(final Collection<Treatment> treatments) {
            return this;
        }
    };

    private final String stat;

    HealthStatus(String stat) {
        this.stat = stat;
    }

    public static HealthStatus fromString(final String stat) {
        for (final HealthStatus status : HealthStatus.values()) {
            if (status.stat.equals(stat))
                return status;
        }
        throw new IllegalStateException("the name of stat'" + stat + "' not exist");
    }

    final HealthStatus healWith(final Collection<Treatment> treatments) {
        if (badTreatment(treatments))
            return DEAD;
        return apply(treatments);
    }

    final void appendStatusToReport(ReportAppendable<HealthStatus> appendable) {
        appendable.append(this);
    }

    @Override
    public String toString() {
        return stat;
    }

    private boolean badTreatment(final Collection<Treatment> listOfTreatments) {
        return listOfTreatments.contains(Treatment.PARACETAMOL)
                && listOfTreatments.contains(Treatment.ASPIRINE);
    }

    protected abstract HealthStatus apply(Collection<Treatment> treatments);
}
