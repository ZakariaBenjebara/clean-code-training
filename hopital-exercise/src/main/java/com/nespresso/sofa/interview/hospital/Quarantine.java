package com.nespresso.sofa.interview.hospital;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static com.nespresso.sofa.interview.hospital.Treatment.*;

final class Quarantine {

    /**
     * To perform this exercise, you will use a readable, maintainable & pragmatic coding style.
     * Please remember that how it's done is as important as the end result.
     * <p>
     * Once finished, send by mail a zip file containing only project artefact's to the person that provide you this exercise
     * If no maximum duration was given, please do not forget to mention in you mail the total time it took...
     * (and any information you might find relevant.)
     * <p>
     * Good luck !
     */
    private final List<Patient> listOfPatients;

    private final TreatmentPlan treatmentPlan = new TreatmentPlan(this);

    private final Reporter reporter = new QuarantineReporter();

    public Quarantine(final String subjects) {
        final String[] diseases = subjects.split(",");
        listOfPatients = createListOfPatients(diseases);
    }

    public void aspirin() {
        cureWith(ASPIRINE);
    }

    public void antibiotic() {
        cureWith(ANTIBIOTIC);
    }

    public void insulin() {
        cureWith(INSULINE);
    }

    public void paracetamol() {
        cureWith(PARACETAMOL);
    }

    public void wait40Days() {
        administerTreatment(treatmentPlan.build());
    }

    public String report() {
        for (final Patient patient : listOfPatients) {
            patient.appendStatToReport(reporter);
        }
        return reporter.report();
    }

    void administerTreatment(final Set<Treatment> treatment) {
        for (final Patient patient : listOfPatients) {
            patient.applyTreatments(treatment);
        }
    }

    private void cureWith(final Treatment treatment) {
        treatmentPlan.add(treatment);
    }

    private static List<Patient> createListOfPatients(final String[] diseases) {
        final List<Patient> patients =  new LinkedList<>();
        for (final String disease : diseases) {
            final HealthStatus healthStatus = HealthStatus.fromString(disease);
            patients.add(Patient.Factory.of(healthStatus));
        }
        return Collections.unmodifiableList(patients);
    }
}
