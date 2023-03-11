package pl.roclawski.bartek.app.translationjobs.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.roclawski.bartek.app.translationjobs.model.Account;
import pl.roclawski.bartek.app.translationjobs.repository.AccountEntity;
import pl.roclawski.bartek.app.translationjobs.repository.AccountRepository;
import pl.roclawski.bartek.app.translationjobs.repository.mapper.AccountMapper;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public Account account(Account account) {
        AccountEntity accountEntity = accountMapper.from(account);
        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);
        Account mappedAccount = accountMapper.from(savedAccountEntity);

        return mappedAccount;
    }

}
