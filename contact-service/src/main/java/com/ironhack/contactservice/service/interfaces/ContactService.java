package com.ironhack.contactservice.service.interfaces;

import com.ironhack.contactservice.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact contact (Long id);

    Contact store(String name, String phoneNumber, String email, String companyName, Long accountId);

    void delete (Long id);

}
