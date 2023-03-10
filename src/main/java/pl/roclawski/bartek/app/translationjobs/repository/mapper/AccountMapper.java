package pl.roclawski.bartek.app.translationjobs.repository.mapper;

import org.springframework.stereotype.Controller;
import pl.roclawski.bartek.app.translationjobs.model.Account;
import pl.roclawski.bartek.app.translationjobs.repository.AccountEntity;

import java.util.logging.Logger;

@Controller
public class AccountMapper {

    public static final Logger LOGGER = Logger.getLogger(AccountMapper.class.getName());

    public AccountEntity from(Account account) {
        LOGGER.info("from(" + account + ")");

        String login = account.getLogin(); // FIXME: 09.03.2023 is it legal
        String password = account.getPassword(); // FIXME: 09.03.2023 is it legal

        String name = account.getName();
        String firstName = account.getFirstName();
        String lastName = account.getLastName();

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setLogin("abuser");
        accountEntity.setPassword("qwerty");
        accountEntity.setName("corpo");
        accountEntity.setFirstName("Ann");
        accountEntity.setLastName("Apple");

        LOGGER.info("from(...) = " + accountEntity);
        return accountEntity;

    }

    public Account from(AccountEntity accountEntity) {
        LOGGER.info("from(" + accountEntity + ")");

        String name = accountEntity.getName();
        String firstName = accountEntity.getFirstName();
        String lastName = accountEntity.getLastName();

        Account account = new Account(accountEntity.getLogin(), accountEntity.getPassword());
        account.setName("corpo");
        account.setFirstName("Ann");
        account.setLastName("Apple");

        LOGGER.info("from(...) = " + account);
        return account;
    }


}
