package com.ironhack.edgeservice.service.impl;


import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
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
        Contact contact = new Contact("Dummy", "", "", "");
        contact.setId(1L);
        Opportunity opportunity = new Opportunity(Product.BOX, 1, contact);
        opportunity.setId(1L);
        return opportunity;

    }

    public void delete(Long id) {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
    }

    public Opportunity save(OpportunityDTO opportunity) {
        return contAccOppServiceClient.add(opportunity);
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
        Contact contact = new Contact("Dummy", "", "", "");
        contact.setId(1L);
        Opportunity opportunity = new Opportunity(Product.BOX, 1, contact);
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

    public List<Object[]> showOpportunitiesBySalesRep(){
        // Aquí debería ir llamada al microservicio de Salesrep para rescatar el nombre del SalesRep con el id
        return contAccOppServiceClient.showOpportunitiesBySalesRep();

    }
    public List<Object[]> showClosedWonOpportunitiesBySalesRep(){
        // Aquí debería ir llamada al microservicio de Salesrep para rescatar el nombre del SalesRep con el id
        return contAccOppServiceClient.showClosedWonOpportunitiesBySalesRep();
    }
    public List<Object[]> showClosedLostOpportunitiesBySalesRep(){
        // Aquí debería ir llamada al microservicio de Salesrep para rescatar el nombre del SalesRep con el id
        return contAccOppServiceClient.showClosedLostOpportunitiesBySalesRep();
    }
    public List<Object[]> showOpenOpportunitiesBySalesRep(){
        // Aquí debería ir llamada al microservicio de Salesrep para rescatar el nombre del SalesRep con el id
        return contAccOppServiceClient.showOpenOpportunitiesBySalesRep();
    }

    public List<Object[]> opportunitiesByProduct() {
        return contAccOppServiceClient.opportunitiesByProduct();
    }

    public List<Object[]> openOpportunitiesByProduct() {
        return contAccOppServiceClient.openOpportunitiesByProduct();
    }

    public List<Object[]> wonOpportunitiesByProduct() {
        return contAccOppServiceClient.wonOpportunitiesByProduct();
    }

    public List<Object[]> lostOpportunitiesByProduct() {
        return contAccOppServiceClient.lostOpportunitiesByProduct();
    }

    public List<Object[]> opportunitiesByCountry() {
        return contAccOppServiceClient.opportunitiesByCountry();
    }

    public List<Object[]> openOpportunitiesByCountry() {
        return contAccOppServiceClient.openOpportunitiesByCountry();
    }

    public List<Object[]> wonOpportunitiesByCountry() {
        return contAccOppServiceClient.wonOpportunitiesByCountry();
    }

    public List<Object[]> lostOpportunitiesByCountry() {
        return contAccOppServiceClient.lostOpportunitiesByCountry();
    }

    public List<Object[]> opportunitiesByCity() {
        return contAccOppServiceClient.opportunitiesByCity();
    }

    public List<Object[]> openOpportunitiesByCity() {
        return contAccOppServiceClient.openOpportunitiesByCity();
    }

    public List<Object[]> wonOpportunitiesByCity() {
        return contAccOppServiceClient.wonOpportunitiesByCity();
    }

    public List<Object[]> lostOpportunitiesByCity() {
        return contAccOppServiceClient.lostOpportunitiesByCity();
    }

    public List<Object[]> opportunitiesByIndustry() {
        return contAccOppServiceClient.opportunitiesByIndustry();
    }

    public List<Object[]> openOpportunitiesByIndustry() {
        return contAccOppServiceClient.openOpportunitiesByIndustry();
    }

    public List<Object[]> wonOpportunitiesByIndustry() {
        return contAccOppServiceClient.wonOpportunitiesByIndustry();
    }

    public List<Object[]> lostOpportunitiesByIndustry() {
        return contAccOppServiceClient.lostOpportunitiesByIndustry();
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
