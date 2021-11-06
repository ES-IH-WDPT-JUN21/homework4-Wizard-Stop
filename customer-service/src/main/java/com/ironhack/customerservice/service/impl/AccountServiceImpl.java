package com.ironhack.customerservice.service.impl;

import com.ironhack.customerservice.controller.dto.AccountDTO;
import com.ironhack.customerservice.model.Account;
import com.ironhack.customerservice.model.Contact;
import com.ironhack.customerservice.model.Opportunity;
import com.ironhack.customerservice.repository.AccountRepository;
import com.ironhack.customerservice.repository.ContactRepository;
import com.ironhack.customerservice.repository.OpportunityRepository;
import com.ironhack.customerservice.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ContactRepository contactRepository;

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
//            Contact contact = contactRepository.getById(accountDTO.getContactId());
//            Opportunity opportunity = opportunityRepository.getById(accountDTO.getOpportunityId());
            account.setCity(accountDTO.getCity());
            account.setCountry(accountDTO.getCountry());
            account.setIndustry(accountDTO.getIndustry());
            account.setEmployeeCount(accountDTO.getEmployeeCount());
//            account.getContacts().add(contact);
//            account.getOpportunities().add(opportunity);

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

    public boolean checkAccount(Long id){
        boolean exists = false;
            Optional<Account> optionalAccount = accountRepository.findById(id);
            if(optionalAccount.isPresent()){
                exists = true;
            }



        return exists;
    }
}
