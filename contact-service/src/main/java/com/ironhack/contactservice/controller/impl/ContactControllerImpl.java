package com.ironhack.contactservice.controller.impl;

import com.ironhack.contactservice.controller.dto.ContactDTO;
import com.ironhack.contactservice.controller.interfaces.ContactController;
import com.ironhack.contactservice.model.Contact;
import com.ironhack.contactservice.service.interfaces.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactControllerImpl implements ContactController {

    @Autowired
    private ContactService contactService;


    @GetMapping("/contacts")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact contact(@PathVariable(name = "id") Long id) {
        return contactService.contact(id);
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact store(@RequestBody @Valid ContactDTO contactDTO) {
        return contactService.store(contactDTO.getName(), contactDTO.getPhoneNumber(), contactDTO.getEmail(),
                contactDTO.getCompanyName(), contactDTO.getAccountId());
    }

    @DeleteMapping("/contacts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "id") Long id) {
        contactService.delete(id);
    }
}
