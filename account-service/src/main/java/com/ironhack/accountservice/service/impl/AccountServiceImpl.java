package com.ironhack.accountservice.service.impl;

import com.ironhack.accountservice.controller.dto.AccountDTO;
import com.ironhack.accountservice.model.Account;
import com.ironhack.accountservice.repository.AccountRepository;
import com.ironhack.accountservice.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account getById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + id + " does not match with any account");
        }
    }

    public Account store(AccountDTO accountDTO)  {
        Optional<Account> optionalAccount = accountRepository.findById(accountDTO.getId());
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        } else {
            Account account = new Account();

            account.setCity(accountDTO.getCity());
            account.setCountry(accountDTO.getCountry());
            account.setIndustry(accountDTO.getIndustry());
            account.setEmployeeCount(accountDTO.getEmployeeCount());
            account.setContactId(accountDTO.getContactId());
            account.setOpportunityId(accountDTO.getOpportunityId());

            return accountRepository.save(account);
        }
    }

    public void deleteById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()){
            accountRepository.delete(optionalAccount.get());
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + id + " does not match with any account");
        }
    }

}

