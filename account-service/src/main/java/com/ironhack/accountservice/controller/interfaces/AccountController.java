package com.ironhack.accountservice.controller.interfaces;

import com.ironhack.accountservice.controller.dto.AccountDTO;
import com.ironhack.accountservice.model.Account;

import java.util.List;

public interface AccountController {
    List<Account> getAll();
    Account getById(Long id);
    Account store(AccountDTO account);
    void deleteById(Long id);
}
