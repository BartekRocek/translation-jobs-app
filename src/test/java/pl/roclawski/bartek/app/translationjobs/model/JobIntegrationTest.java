package pl.roclawski.bartek.app.translationjobs.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class JobIntegrationTest {

    private static final String businessName = "KFC";

    Customer firstCustomer;// = new Customer("client", "1234");
    Job jobGiven; //= new Job(firstCustomer, businessName);

    @BeforeEach
    void setUp() {
        firstCustomer = new Customer("client", "1234");
        jobGiven = new Job(firstCustomer, businessName);
    }

    @AfterEach
    void tearDown() {
        firstCustomer = null;
        jobGiven = null;
    }

    @Test
    void assign() {
        // given
        Contractor masterContractor = new Contractor("contractor_login", "qwerty");

        // when
        jobGiven.assign(masterContractor);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(jobGiven.created, "created is null"),
                () -> Assertions.assertNotNull(jobGiven.assigned, "assigned is null"),
                () -> Assertions.assertNotNull(jobGiven.name, "name is null")
        );
    }

    @Test
    void receive() {
        // given
        Quote jobGivenWithoutQuote = null;
        Quote jobGivenQuote = new Quote();
//        JobStatus jobGivenStatus;

        // when
        JobStatus receivedWithQuote = jobGiven.receive(jobGivenQuote);
        JobStatus receivedWithoutQuote = jobGiven.receive(jobGivenWithoutQuote);


        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(receivedWithQuote, "The quote is null"),
                () -> Assertions.assertEquals(JobStatus.TO_ACCEPT, receivedWithoutQuote, "The status should be TO_ACCEPT")
        );

    }

    @Test
    void changeStatus() {
        // given

        // when
        JobStatus jobStatusChanged = jobGiven.changeStatus(JobStatus.TO_ACCEPT);

        // then
        Assertions.assertEquals(jobStatusChanged, JobStatus.TO_ACCEPT, "The JobStatus should be " + JobStatus.TO_ACCEPT);

    }

    @Test
    void integrationTest() {
        // given
        Customer superRichCustomer = new Customer("login", "password");
        Job simpleJob = new Job(superRichCustomer, "bisCompany");
        Contractor masterContractor = new Contractor("contractor_login", "qwerty");
        Quote superRichCustomerQuote = new Quote();

        // when
        simpleJob.assign(masterContractor);
        JobStatus receive = simpleJob.receive(superRichCustomerQuote);
        BigDecimal masterContractorQuoteProvided = superRichCustomerQuote.provide(BigDecimal.TEN);
        JobStatus jobStatusAfterQuoting = simpleJob.changeStatus(JobStatus.TO_ACCEPT);

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(JobStatus.QUOTING, receive, "The JobStatus should be " + JobStatus.QUOTING),
                () -> Assertions.assertNotNull(masterContractorQuoteProvided, "The Quote cannot be null"),
                () -> Assertions.assertEquals(JobStatus.TO_ACCEPT, jobStatusAfterQuoting, "The JobStatus should be " + JobStatus.TO_ACCEPT)
        );


    }
}
