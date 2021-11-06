package com.ironhack.customerservice.service.impl;

import com.ironhack.customerservice.controller.dto.ContactDTO;
import com.ironhack.customerservice.model.Account;
import com.ironhack.customerservice.model.Contact;
import com.ironhack.customerservice.repository.AccountRepository;
import com.ironhack.customerservice.repository.ContactRepository;
import com.ironhack.customerservice.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountRepository accountRepository;



    @Override
    public List<Contact> findAll() {
        List<Contact> contactList = contactRepository.findAll();
        if (contactList.size() != 0) {
            return contactList;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no contacts in database.");
    }

    @Override
    public Contact contact(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + id + " does not match with any contact"));
    }

    @Override
    public Contact store(String name, String phoneNumber, String email, String companyName, Long accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId); // Aquí habría que llamar al microservicio de Account
        if(optionalAccount.isPresent()){
            Contact contact = new Contact();
            contact.setName(name);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
            contact.setCompanyName(companyName);
            contact.setAccount(optionalAccount.get());
            contactRepository.save(contact);
            Account account = optionalAccount.get();
            account.addContact(contact);
            accountRepository.save(account);
            ContactDTO contactDTO = new ContactDTO(name,phoneNumber,email,companyName,accountId);
            return contact;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + accountId + " does not match with any account");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);

        if (optionalContact.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + id + " does not match with any contact");
        } else {
            contactRepository.delete(optionalContact.get());
        }
    }
}
