package com.ironhack.customerservice.service.interfaces;

import com.ironhack.customerservice.controller.dto.AccountDTO;
import com.ironhack.customerservice.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
    Account getById(Long id);
    Account store(AccountDTO account);
    void deleteById(Long id);
}
