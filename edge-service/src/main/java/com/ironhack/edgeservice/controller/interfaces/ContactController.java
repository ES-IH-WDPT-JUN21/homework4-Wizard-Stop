package com.ironhack.edgeservice.controller.interfaces;


import com.ironhack.edgeservice.controller.dto.ContactDTO;
import com.ironhack.edgeservice.model.Contact;

import java.util.List;

public interface ContactController {

    Contact findById(Long id);
    List<Contact> findAll();
    ContactDTO store(ContactDTO contactDTO);
    void delete(Long id);
}
