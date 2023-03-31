package pl.roclawski.bartek.app.translationjobs.service;

import org.springframework.stereotype.Service;
import pl.roclawski.bartek.app.translationjobs.controller.AccountController;
import pl.roclawski.bartek.app.translationjobs.model.Account;
import pl.roclawski.bartek.app.translationjobs.repository.AccountEntity;
import pl.roclawski.bartek.app.translationjobs.repository.AccountRepository;
import pl.roclawski.bartek.app.translationjobs.repository.mapper.AccountMapper;

import java.util.logging.Logger;

@Service
public class AccountService {

    public static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public Account create(Account account) {
        LOGGER.info("create(" + account + ")");

        AccountEntity accountEntity = accountMapper.from(account);
        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);
        Account mappedAccount = accountMapper.from(savedAccountEntity);

        LOGGER.info("create(...) = " + mappedAccount);
        return mappedAccount;
    }

}
