package pl.roclawski.bartek.app.translationjobs.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Logger;

public class Job {

    public static final Logger LOGGER = Logger.getLogger(Job.class.getName());

    Customer customer;
    Quote quote;
    BigDecimal amountDue;
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

    public BigDecimal finish(BigDecimal amountDue) {
        LOGGER.info("finish(" + amountDue + ")");
        this.amountDue = amountDue;
        changeStatus(JobStatus.FINISHED);
        LOGGER.info("finish(...) = " + this.amountDue);
        return this.amountDue;
    }

    public JobStatus getStatus() {
        return status;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }
}
