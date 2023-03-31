package pl.roclawski.bartek.app.translationjobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.roclawski.bartek.app.translationjobs.model.Account;
import pl.roclawski.bartek.app.translationjobs.service.AccountService;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/accounts")
public class AccountController {
    public static final Logger LOGGER = Logger.getLogger(AccountController.class.getName());

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");

        return "accounts/create";
    }

    @PostMapping
    public String create(Account account) {
        LOGGER.info("create(" + account + ")");

        accountService.create(account);
        return "accounts/create";
    }

    // R - read
    public Account read(Integer id) {
        return null;
    }

    // U - update
    public Account update(Integer id, Account account) {
        return null;
    }

    // D - delete
    public void delete(Integer id) {
    }

    // L - list
    @GetMapping
    public String list() {
        LOGGER.info("list()");

        return "accounts/accounts";
    }

}

// TODO: 06.03.2023 Dodać wartwę Service, Mapper i Repository dla modelu dziedziny Account
//  Napisać testy jednostkowe dla Repository i Mapper
//  Wstrzyknąć zależności pomiędzy warstwami