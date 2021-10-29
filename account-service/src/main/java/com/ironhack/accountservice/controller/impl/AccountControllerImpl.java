package com.ironhack.accountservice.controller.impl;

import com.ironhack.accountservice.controller.dto.AccountDTO;
import com.ironhack.accountservice.controller.interfaces.AccountController;
import com.ironhack.accountservice.model.Account;
import com.ironhack.accountservice.service.interfaces.AccountService;
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
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getById(@PathVariable Long id) {
        return accountService.getById(id);
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
