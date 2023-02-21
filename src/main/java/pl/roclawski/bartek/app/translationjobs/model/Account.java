package pl.roclawski.bartek.app.translationjobs.model;

public class Account {

    String login;
    String password;

    String name;
    String firstName;
    String lastName;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
