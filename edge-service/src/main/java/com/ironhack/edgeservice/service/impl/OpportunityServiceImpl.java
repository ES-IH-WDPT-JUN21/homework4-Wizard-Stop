package com.ironhack.edgeservice.service.impl;


import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.enums.Product;
import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.model.Contact;
import com.ironhack.edgeservice.model.Opportunity;
import com.ironhack.edgeservice.model.SalesRep;
import com.ironhack.edgeservice.service.interfaces.OpportunityService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    ContAccOppServiceClient contAccOppServiceClient;

    private final Logger logger = LoggerFactory.getLogger(OpportunityServiceImpl.class);

    @CircuitBreaker(name = "findById", fallbackMethod = "findByIdFallback")
    public Opportunity findById(Long id) {
        return contAccOppServiceClient.getById(id);
    }

    public Opportunity findByIdFallback(Long id, Exception e) {
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        //Respuesta que lanzaremos cuando la latencia de respuesta supere los 2s
        Contact contact = new Contact("Mario", "345788543", "marioo@gmail.com", "Nosep");
        contact.setId(1L);
        Opportunity opportunity = new Opportunity(Product.BOX, 12, contact);
        opportunity.setId(1L);
        return opportunity;

        //throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
    }

    public void delete(Long id) {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
    }

    public void save(Opportunity opportunity) {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
    }

    public Account findAccountByOpportunity(Opportunity opportunity) {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    @CircuitBreaker(name = "getAll", fallbackMethod = "getAllFallback")
    public List<Opportunity> getAll() {
        return contAccOppServiceClient.getAll();
    }

    public List<Opportunity> getAllFallback(Exception e) {
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        //Respuesta que lanzaremos cuando la latencia de respuesta supere los 2s
        Contact contact = new Contact("Mario", "345788543", "marioo@gmail.com", "Nosep");
        contact.setId(1L);
        Opportunity opportunity = new Opportunity(Product.BOX, 12, contact);
        opportunity.setId(1L);
        List<Opportunity> list = new ArrayList<>();
        list.add(opportunity);
        return list;
    }

    public Opportunity obtainOpportunity(Contact contact, SalesRep salesRep) {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public String closeLost(Long id) {
    return contAccOppServiceClient.closeLost(id);
    }

    public String closeWon(Long id) {
        return contAccOppServiceClient.closeWon(id);

    }

    public List<Object[]> opportunitiesByProduct() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> openOpportunitiesByProduct() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> wonOpportunitiesByProduct() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> lostOpportunitiesByProduct() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> opportunitiesByCountry() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> openOpportunitiesByCountry() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> wonOpportunitiesByCountry() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> lostOpportunitiesByCountry() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> opportunitiesByCity() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> openOpportunitiesByCity() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> wonOpportunitiesByCity() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> lostOpportunitiesByCity() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> opportunitiesByIndustry() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> openOpportunitiesByIndustry() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> wonOpportunitiesByIndustry() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public List<Object[]> lostOpportunitiesByIndustry() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public double getMeanEmployeeCount() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return 0.00;
    }

    public BigDecimal getMedianEmployeeCount() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public int getMaxEmployeeCount() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return 0;
    }

    public int getMinEmployeeCount() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return 0;
    }

    public double getMeanQuantityOfProducts() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return 0.00;
    }

    public BigDecimal getMedianQuantityOfProducts() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }


    public int getMaxQuantityOfProducts() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return 0;
    }

    public int getMinQuantityOfProducts() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return 0;
    }

    public double getMeanOpportunitiesPerAccount() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return 0.00;
    }

    public BigDecimal getMedianOpportunitiesPerAccount() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public int getMaxOpportunitiesPerAccount() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return 0;
    }

    public int getMinOpportunitiesPerAccount() throws IllegalStateException {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return 0;
    }
}
