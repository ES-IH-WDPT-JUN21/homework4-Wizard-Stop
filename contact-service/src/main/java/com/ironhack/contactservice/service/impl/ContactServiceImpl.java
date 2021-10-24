package com.ironhack.contactservice.service.impl;

import com.ironhack.contactservice.model.Contact;
import com.ironhack.contactservice.repository.ContactRepository;
import com.ironhack.contactservice.service.interfaces.ContactService;
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
        Optional<Contact> optionalContact = contactRepository.findById(id);

        if (optionalContact.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID " + id + " does not match with any contact");
        } else {
            return optionalContact.get();
        }
    }

    @Override
    public Contact store(String name, String phoneNumber, String email, String companyName, Long accountId) {

        Contact contact = new Contact(name,phoneNumber,email,companyName, accountId);
            return contactRepository.save(contact);

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
