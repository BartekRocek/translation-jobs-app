package pl.roclawski.bartek.app.translationjobs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuoteTest {

    @Test
    void accept() {
        // given
        Quote customerQuote = new Quote();

        // when
        boolean quoteAccepted = customerQuote.accept();

        //then
        Assertions.assertTrue(quoteAccepted, "The quote should be accepted");
    }

    @Test
    void reject() {
        //given
        Quote customerQuote = new Quote();

        //when
        boolean quoteRejected = customerQuote.reject();

        //then
        Assertions.assertFalse(quoteRejected, "The quote should be rejected");
    }
}