package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.dto.AccountDTO;
import com.ironhack.edgeservice.controller.interfaces.AccountController;
import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.service.interfaces.AccountService;
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
    public Account getAccountById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account store(@RequestBody @Valid AccountDTO account) {
        return accountService.save(account);
    }

    @DeleteMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteById(@PathVariable Long id) {
        accountService.delete(id);
    }
}
