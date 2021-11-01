package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.AccountDTO;
import com.ironhack.edgeservice.model.Account;

import java.util.List;

public interface AccountController {

    List<Account> getAll();
    Account getAccountById(Long id);
    Account store(AccountDTO account);
    void deleteById(Long id);
}
