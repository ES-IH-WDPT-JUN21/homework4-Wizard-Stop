package com.ironhack.accountservice.service.interfaces;

import com.ironhack.accountservice.controller.dto.AccountDTO;
import com.ironhack.accountservice.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
    Account getById(Long id);
    Account store(AccountDTO account);
    void deleteById(Long id);
}