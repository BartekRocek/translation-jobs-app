package pl.roclawski.bartek.app.translationjobs;

import pl.roclawski.bartek.app.translationjobs.model.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class ApplicationCli {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Witamy w nowym, rewolucyjnym systemie współpracy!");

        System.out.println("Podaj login");
        String login = scanner.next();

        System.out.println("Podaj hasło");
        String password = scanner.next();

        Customer superRichCustomer = new Customer(login, password);

        Job simpleJob = new Job(superRichCustomer, "bisCompany");

        Contractor masterContractor = new Contractor("contractor_login", "qwerty");
        simpleJob.assign(masterContractor);

        System.out.println("Wgraj plik ze zleceniem");
        System.out.println("Czy chcesz wycenę?");

        String quoteRequested = scanner.next();
        Quote superRichCustomerQuote = new Quote();

        if (quoteRequested.equalsIgnoreCase("tak")) {
            JobStatus receive = simpleJob.receive(superRichCustomerQuote);
            System.out.println("Obecny status: " + receive);
            System.out.println("Podaj cenę dla klienta.");

            BigDecimal masterContractorQuoteAmount = scanner.nextBigDecimal();
            BigDecimal masterContractorQuoteProvided = superRichCustomerQuote.provide(masterContractorQuoteAmount);

            JobStatus jobStatusAfterQuoting = simpleJob.changeStatus(JobStatus.TO_ACCEPT);
            System.out.println("Obecny status: " + jobStatusAfterQuoting);
        } else if (quoteRequested.equalsIgnoreCase("nie")) {
            JobStatus receive = simpleJob.receive(null);
            System.out.println("Obecny status: " + receive);
        }

        System.out.println("Wpisz cenę po wykonaniu zlecenia!");
        BigDecimal masterContractorAmountDue = scanner.nextBigDecimal();
        BigDecimal simpleJobAmountDue = simpleJob.finish(masterContractorAmountDue);

    }
}

// TODO: 17.02.2023 Dokończyć implementację przyjęcia zlecenia od klienta oraz zmianę statusu
//  pobrać wszystkie dane za pomocą Scannera