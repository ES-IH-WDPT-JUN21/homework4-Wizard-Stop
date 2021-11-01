package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.controller.dto.AccountDTO;
import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.model.Contact;
import com.ironhack.edgeservice.model.Opportunity;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface AccountService {
    Account findById(Long id) throws InvalidParameterException, NoSuchElementException;

    void delete(Long id) throws InvalidParameterException, NoSuchElementException;

    Account save(AccountDTO account);

    Account obtainAccount(Contact contact, Opportunity opportunity);

    List<Account> getAll();
}
