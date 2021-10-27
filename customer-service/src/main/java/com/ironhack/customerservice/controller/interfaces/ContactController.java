package com.ironhack.customerservice.controller.interfaces;

import com.ironhack.customerservice.controller.dto.ContactDTO;
import com.ironhack.customerservice.model.Contact;

import java.util.List;

public interface ContactController {

    List<Contact> findAll();

    Contact contact (Long id);

    ContactDTO store(ContactDTO contactDTO);

    void delete (Long id);
}
