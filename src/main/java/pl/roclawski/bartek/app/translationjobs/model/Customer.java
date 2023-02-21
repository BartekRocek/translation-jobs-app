package pl.roclawski.bartek.app.translationjobs.model;

public class Customer extends Account {

    Address address;

    public Customer(String login, String password) {
        super(login, password);
    }
}
