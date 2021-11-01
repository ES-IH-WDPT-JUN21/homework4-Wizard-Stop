package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.dto.ContactDTO;
import com.ironhack.edgeservice.controller.interfaces.ContactController;
import com.ironhack.edgeservice.model.Contact;
import com.ironhack.edgeservice.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactControllerImpl implements ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact findById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @GetMapping("/contacts")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> findAll() {
        return contactService.getAll();
    }


    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO store(@RequestBody @Valid ContactDTO contactDTO) {
        return contactService.save(contactDTO);
    }

    @DeleteMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "id") Long id) {
        contactService.delete(id);
    }
}
