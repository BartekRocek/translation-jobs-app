package pl.roclawski.bartek.app.translationjobs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class JobTest {

    public static final BigDecimal AMOUNT_DUE_500 = BigDecimal.valueOf(500);

    @Test
    void give_when_then() {
        // given
        Customer customer = new Customer(null, null);
        Job job = new Job(customer, "translation");

        // when
        // purposefully left blank

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(job.created, "created is null"),
                () -> Assertions.assertNotNull(job.customer, "customer is null"),
                () -> Assertions.assertNotNull(job.name, "name is null")
        );
    }


    @Test
    void assign() {
        // given
        Customer customer = new Customer(null, null);
        Job job = new Job(customer, "interpretation");

        Contractor contractor = new Contractor(null, null);

        // when
        job.assign(contractor);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(job.contractor, "contractor is null"),
                () -> Assertions.assertNotNull(job.assigned, "assigned is null")
        );
    }

    @Test
    void start() {
        // given
        Customer customer = new Customer(null, null);
        Job job = new Job(customer, "interpretation");

        // when
        JobStatus jobStatus = job.receive(null);

        // then
        Assertions.assertEquals(JobStatus.IN_PROGRESS, jobStatus, "jobStatus is not equal to " + JobStatus.IN_PROGRESS);
// TODO: 02.02.2023 Zastanowić się, dlaczego zwraca IN_PROGRESS i czy w metodzie start nie uwzględnić pola contractor
//  Jaki domyślny początkowy status powinno mieć pole status w Job i gdzie je ustawiać
    }

    @Test
    void start_with_quote() {
        // given
        Customer customer = new Customer(null, null);
        Job job = new Job(customer, "interpretation");

        // when
        JobStatus jobStatus = job.receive(new Quote());

        // then
        Assertions.assertEquals(JobStatus.QUOTING, jobStatus, "jobStatus is not equal to " + JobStatus.QUOTING);
    }

    @Test
    void given_when_then() {
        // given
        Job job = new Job(null, null);

        // when
        //nothing to do

        // then
        Assertions.assertEquals(JobStatus.NEW, job.getStatus(), "jobStatus is not equal to " + JobStatus.NEW);

    }

    @Test
    void givenJobStatus_whenChangeStatus_thenJobStatusChangedEqualsStatus() {
        // given
        Job job = new Job(null, null);
        JobStatus jobStatus = JobStatus.SETTLED;

        // when
        JobStatus jobStatusChanged = job.changeStatus(jobStatus);

        // then
        Assertions.assertEquals(JobStatus.SETTLED, jobStatusChanged, "Wrong! The JobStatus.SETTLED is" + jobStatusChanged);
        System.out.println(jobStatusChanged.getMessage());
    }

    @Test
    void finish() {
        // given
        Job job = new Job(null, null);

        // when
        BigDecimal amountDue = job.finish(AMOUNT_DUE_500);

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(AMOUNT_DUE_500, amountDue, "Not equals " + AMOUNT_DUE_500),
                () -> Assertions.assertEquals(JobStatus.FINISHED, job.getStatus(), "Status is NOT " + JobStatus.FINISHED)
        );
    }


}
