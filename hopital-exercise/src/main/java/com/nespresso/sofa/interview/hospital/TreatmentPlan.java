package com.nespresso.sofa.interview.hospital;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class TreatmentPlan {

    private final Set<Treatment> listOfTreatments = new HashSet<>();

    private final Quarantine quarantine;

    TreatmentPlan(Quarantine quarantine) {
        this.quarantine = quarantine;
    }

    TreatmentPlan add(final Treatment treatment) {
        listOfTreatments.add(treatment);
        if (badTreatment())
            quarantine.administerTreatment(listOfTreatments);
        return this;
    }

    private boolean badTreatment() {
        return listOfTreatments.contains(Treatment.PARACETAMOL)
                && listOfTreatments.contains(Treatment.ASPIRINE);
    }

    Set<Treatment> build() {
        return Collections.unmodifiableSet(listOfTreatments);
    }
}
