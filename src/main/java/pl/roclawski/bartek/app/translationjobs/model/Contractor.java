package pl.roclawski.bartek.app.translationjobs.model;

public class Contractor extends Account {

    Address address;

    public Contractor(String login, String password) {
        super(login, password);
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "address=" + address +
                "} " + super.toString();
    }
}
