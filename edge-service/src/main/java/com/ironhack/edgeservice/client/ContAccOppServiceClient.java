package com.ironhack.edgeservice.client;


import com.ironhack.edgeservice.dto.ContactDTO;
import com.ironhack.edgeservice.model.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("contact-service")
public interface ContAccOppServiceClient {

    @GetMapping("/contacts")
    public List<Contact> findAll();

    @GetMapping("/contacts/{id}")
    public Contact contact(@PathVariable(name = "id") Long id);

    @PostMapping("/contacts")
    public Contact store(@RequestBody ContactDTO contactDTO);
}
