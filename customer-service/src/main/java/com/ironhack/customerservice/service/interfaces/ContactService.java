package com.ironhack.customerservice.service.interfaces;

import com.ironhack.customerservice.controller.dto.ContactDTO;
import com.ironhack.customerservice.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact contact (Long id);

    Contact store(String name, String phoneNumber, String email, String companyName, Long accountId);

    void delete (Long id);
}
