package pl.roclawski.bartek.app.translationjobs.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class AccountRepositoryTest {

    public static final String ACCOUNT_NAME_LTD = "LTD";
    public static final String ACCOUNT_FIRST_NAME_JOHN = "John";
    public static final String ACCOUNT_LAST_NAME_BROWN = "Brown";
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void test() {
        // given

        // when
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(1L);
        AccountEntity foundAccountEntity = optionalAccountEntity.orElse(new AccountEntity());

        // then
        Assertions.assertNotNull(foundAccountEntity, "foundAccountEntity is null");
    }

    @Test
    void create() {
        // given
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(ACCOUNT_NAME_LTD);
        accountEntity.setFirstName(ACCOUNT_FIRST_NAME_JOHN);
        accountEntity.setLastName(ACCOUNT_LAST_NAME_BROWN);
        // when
        accountRepository.save(accountEntity);

        // then

    }


}