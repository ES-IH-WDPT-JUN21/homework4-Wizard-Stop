package com.ironhack.edgeservice.service.interfaces;


import com.ironhack.edgeservice.model.Contact;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface ContactService {

    void delete(Long id);

    Contact findById(Long id) ;

    void save(Contact contact);

    List<Contact> getAll();
}
