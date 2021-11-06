package com.ironhack.customerservice.controller.impl;

import com.ironhack.customerservice.controller.dto.AccountDTO;
import com.ironhack.customerservice.controller.interfaces.AccountController;
import com.ironhack.customerservice.model.Account;
import com.ironhack.customerservice.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts() {
        return accountService.getAll();
    }

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @GetMapping("/checkaccounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean checkAccount(@PathVariable Long id) {
        return accountService.checkAccount(id);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account store(@RequestBody @Valid AccountDTO account) {
        return accountService.store(account);
    }

    @DeleteMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteById(@PathVariable Long id) {
        accountService.deleteById(id);
    }
}
