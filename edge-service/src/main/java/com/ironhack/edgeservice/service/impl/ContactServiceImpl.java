package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.model.Contact;
import com.ironhack.edgeservice.service.interfaces.ContactService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContAccOppServiceClient contAccOppServiceClient;

    public void delete(Long id) throws InvalidParameterException, NoSuchElementException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
    }

        // ejemplo llamada a microservicio y fallback
    @CircuitBreaker(name = "findById", fallbackMethod = "findByIdFallback")
    public Contact findById(Long id) {
            return contAccOppServiceClient.contact(id);
    }

    public Contact findByIdFallback(Long id, Exception e) throws NoSuchElementException {
        throw new NoSuchElementException("The ID " + id + " does not match with any contact");
    }

    public void save(Contact contact) {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
    }

    public List<Contact> getAll() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }
}
