package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.AccountController;
import com.ironhack.edgeservice.service.interfaces.AccountService;
import com.ironhack.edgeservice.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountService accountService;
}
