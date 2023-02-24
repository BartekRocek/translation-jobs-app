package pl.roclawski.bartek.app.translationjobs.model;

import java.math.BigDecimal;

public class Quote {

    BigDecimal amount;
    boolean accepted;

    public BigDecimal provide(BigDecimal amount) {
        this.amount = amount;
        return this.amount;
    }

    public boolean accept() {
        this.accepted = true;
        return true;
    }

    public boolean reject() {
        this.accepted = false;
        return false;
    }
}

// TODO: 20.02.2023 Napisać testy jednostkowe
//  w szczególności test integracyjny dla wszystkich metod klasy Job (w klasie JobIntegrationTest), tak jak wyglądałaby interakcja z klientem!!!