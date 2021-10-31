package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.AccountController;
import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.service.interfaces.AccountService;
import com.ironhack.edgeservice.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
