package com.ironhack.edgeservice.service.impl;


import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.enums.Status;
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
import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    ContAccOppServiceClient contAccOppServiceClient;

    @CircuitBreaker(name = "findById", fallbackMethod = "findByIdFallback")
    public Opportunity findById(Long id) {
        return contAccOppServiceClient.getById(id);
    }

    public Opportunity findByIdFallback(Long id, Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
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
//    @CircuitBreaker(name = "getAll", fallbackMethod = "getAllFallback")
    public List<Opportunity> getAll() {
        return contAccOppServiceClient.getAll();

    }
//    public String getAllFallback(Exception e) throws NoSuchElementException{
//        return e.getMessage();
//
//    }

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
