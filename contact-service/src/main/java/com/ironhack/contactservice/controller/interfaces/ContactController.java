package com.ironhack.contactservice.controller.interfaces;

import com.ironhack.contactservice.controller.dto.ContactDTO;
import com.ironhack.contactservice.model.Contact;

import java.util.List;

public interface ContactController {

    List<Contact> findAll();

    Contact contact (Long id);

    Contact store(ContactDTO contactDTO);

    void delete (Long id);
}
