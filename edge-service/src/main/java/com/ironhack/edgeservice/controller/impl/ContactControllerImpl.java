package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.ContactController;
import com.ironhack.edgeservice.model.Contact;
import com.ironhack.edgeservice.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactControllerImpl implements ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact findById(@PathVariable Long id) {
        return contactService.findById(id);
    }
}
