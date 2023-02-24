package pl.roclawski.bartek.app.translationjobs.model;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Job {

    public static final Logger LOGGER = Logger.getLogger(Job.class.getName());

    Customer customer;
    Quote quote;
    Contractor contractor;

    String name;
    LocalDate created;
    LocalDate assigned;
    LocalDate finished;
    JobStatus status = JobStatus.NEW;

    public Job(Customer customer, String name) {
        this.customer = customer;
        this.name = name;
        this.created = LocalDate.now();
    }

    public void assign(Contractor contractor) {
        LOGGER.info("assign(" + contractor + ")");
        this.contractor = contractor;
        this.assigned = LocalDate.now();
        LOGGER.info("assigned() = " + this.assigned);
    }

    public JobStatus receive(Quote jobQuote) {
        LOGGER.info("receive(" + jobQuote + ")");
        this.quote = jobQuote;

        if (this.quote == null) {
            this.status = JobStatus.TO_ACCEPT;
        } else {
            this.status = JobStatus.QUOTING;
        }
        LOGGER.info("receive(...) = " + status);
        return status;
    }

    public JobStatus changeStatus(JobStatus jobStatus) {
        LOGGER.info("changeStatus(" + jobStatus + ")");
        this.status = jobStatus;

        LOGGER.info("changeStatus(...) = " + status);
        return this.status;
    }
// TODO: 13.02.2023 Dodać loggery do wszystkich metod publicznych
//  Dla modelu Job stworzyć 3 warstwy Controller, Service, Repository i w każdej warstwie metody CRUD wydmuszki (JobController, JobService itd) DID od controllera w dół
//  Przełączyć się na IntelliJ Community Edition
    public JobStatus getStatus() {
        return status;
    }
}
