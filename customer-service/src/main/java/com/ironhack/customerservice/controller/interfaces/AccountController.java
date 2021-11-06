package com.ironhack.customerservice.controller.interfaces;

import com.ironhack.customerservice.controller.dto.AccountDTO;
import com.ironhack.customerservice.model.Account;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AccountController {
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account store(AccountDTO account);
    void deleteById(Long id);
    boolean checkAccount(Long id);
}
