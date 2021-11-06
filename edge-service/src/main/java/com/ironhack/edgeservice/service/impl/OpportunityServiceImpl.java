package com.ironhack.edgeservice.service.impl;


import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.enums.Product;
import com.ironhack.edgeservice.model.*;
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
    
    @Autowired
    private SalesRepServiceClient salesRepServiceClient;

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

        Contact contact = new Contact("Dummy", "", "", "");
        contact.setId(1L);
        Opportunity opportunity = new Opportunity(Product.BOX, 1, contact);
        opportunity.setId(1L);
        return opportunity;

    }

    public void delete(Long id) {

    }

    public Opportunity save(OpportunityDTO opportunity) {
        return contAccOppServiceClient.add(opportunity);
    }

    public Account findAccountByOpportunity(Opportunity opportunity) {

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

        Contact contact = new Contact("Dummy", "", "", "");
        contact.setId(1L);
        Opportunity opportunity = new Opportunity(Product.BOX, 1, contact);
        opportunity.setId(1L);
        List<Opportunity> list = new ArrayList<>();
        list.add(opportunity);
        return list;
    }

    public Opportunity obtainOpportunity(Contact contact, SalesRep salesRep) {

        return null;
    }

    public String closeLost(Long id) {
    return contAccOppServiceClient.closeLost(id);
    }

    public String closeWon(Long id) {
        return contAccOppServiceClient.closeWon(id);

    }
   
   @CircuitBreaker(name = "showOpportunitiesBySalesRep", fallbackMethod = "Fallback")
    public List<Object[]> showOpportunitiesBySalesRep(){

        List<Object[]> inList = contAccOppServiceClient.showOpportunitiesBySalesRep();
        List<Object[]> outList = new ArrayList<>();
        for(Object[] objects: inList) {
            SalesRep name = salesRepServiceClient.getSalesRepById(Long.valueOf((Integer) objects[0])); //names
            Object opportunities = "opportunities: " + objects[1];
            Object[] newObjects = {name, opportunities};
            outList.add(newObjects);
        }
        return outList;
    }

    @CircuitBreaker(name = "showClosedWonOpportunitiesBySalesRep", fallbackMethod = "Fallback")
    public List<Object[]> showClosedWonOpportunitiesBySalesRep(){

        List<Object[]> inList = contAccOppServiceClient.showClosedWonOpportunitiesBySalesRep();
        List<Object[]> outList = new ArrayList<>();
        for(Object[] objects: inList) {
            SalesRep name = salesRepServiceClient.getSalesRepById(Long.valueOf((Integer) objects[0])); //names
            Object opportunities = "opportunities: " + objects[1];
            Object[] newObjects = {name, opportunities};
            outList.add(newObjects);
        }
        return outList;
    }

    @CircuitBreaker(name = "showClosedLostOpportunitiesBySalesRep", fallbackMethod = "Fallback")
    public List<Object[]> showClosedLostOpportunitiesBySalesRep(){

        List<Object[]> inList = contAccOppServiceClient.showClosedLostOpportunitiesBySalesRep();
        List<Object[]> outList = new ArrayList<>();
        for(Object[] objects: inList) {
            SalesRep name = salesRepServiceClient.getSalesRepById(Long.valueOf((Integer) objects[0])); //names
            Object opportunities = "opportunities: " + objects[1];
            Object[] newObjects = {name, opportunities};
            outList.add(newObjects);
        }
        return outList;
    }

    @CircuitBreaker(name = "showOpenOpportunitiesBySalesRep", fallbackMethod = "Fallback")
    public List<Object[]> showOpenOpportunitiesBySalesRep(){

        List<Object[]> inList = contAccOppServiceClient.showOpenOpportunitiesBySalesRep();
        List<Object[]> outList = new ArrayList<>();
        for(Object[] objects: inList) {
            SalesRep name = salesRepServiceClient.getSalesRepById(Long.valueOf((Integer) objects[0])); //names
            Object opportunities = "opportunities: " + objects[1];
            Object[] newObjects = {name, opportunities};
            outList.add(newObjects);
        }
        return outList;
    }

    @CircuitBreaker(name = "opportunitiesByProduct", fallbackMethod = "Fallback")
    public List<Object[]> opportunitiesByProduct() {
        return contAccOppServiceClient.opportunitiesByProduct();
    }


    @CircuitBreaker(name = "openOpportunitiesByProduct", fallbackMethod = "Fallback")
    public List<Object[]> openOpportunitiesByProduct() {
        return contAccOppServiceClient.openOpportunitiesByProduct();
    }


    @CircuitBreaker(name = "wonOpportunitiesByProduct", fallbackMethod = "Fallback")
    public List<Object[]> wonOpportunitiesByProduct() {
        return contAccOppServiceClient.wonOpportunitiesByProduct();
    }

    @CircuitBreaker(name = "lostOpportunitiesByProduct", fallbackMethod = "Fallback")
    public List<Object[]> lostOpportunitiesByProduct() {
        return contAccOppServiceClient.lostOpportunitiesByProduct();
    }
    @CircuitBreaker(name = "opportunitiesByCountry", fallbackMethod = "Fallback")
    public List<Object[]> opportunitiesByCountry() {
        return contAccOppServiceClient.opportunitiesByCountry();
    }
    @CircuitBreaker(name = "openOpportunitiesByCountry", fallbackMethod = "Fallback")
    public List<Object[]> openOpportunitiesByCountry() {
        return contAccOppServiceClient.openOpportunitiesByCountry();
    }
    @CircuitBreaker(name = "wonOpportunitiesByCountry", fallbackMethod = "Fallback")
    public List<Object[]> wonOpportunitiesByCountry() {
        return contAccOppServiceClient.wonOpportunitiesByCountry();
    }
    @CircuitBreaker(name = "lostOpportunitiesByCountry", fallbackMethod = "Fallback")
    public List<Object[]> lostOpportunitiesByCountry() {
        return contAccOppServiceClient.lostOpportunitiesByCountry();
    }
    @CircuitBreaker(name = "opportunitiesByCity", fallbackMethod = "Fallback")
    public List<Object[]> opportunitiesByCity() {
        return contAccOppServiceClient.opportunitiesByCity();
    }
    @CircuitBreaker(name = "openOpportunitiesByCity", fallbackMethod = "Fallback")
    public List<Object[]> openOpportunitiesByCity() {
        return contAccOppServiceClient.openOpportunitiesByCity();
    }
    @CircuitBreaker(name = "wonOpportunitiesByCity", fallbackMethod = "Fallback")
    public List<Object[]> wonOpportunitiesByCity() {
        return contAccOppServiceClient.wonOpportunitiesByCity();
    }
    @CircuitBreaker(name = "lostOpportunitiesByCity", fallbackMethod = "Fallback")
    public List<Object[]> lostOpportunitiesByCity() {
        return contAccOppServiceClient.lostOpportunitiesByCity();
    }
    @CircuitBreaker(name = "opportunitiesByIndustry", fallbackMethod = "Fallback")
    public List<Object[]> opportunitiesByIndustry() {
        return contAccOppServiceClient.opportunitiesByIndustry();
    }
    @CircuitBreaker(name = "openOpportunitiesByIndustry", fallbackMethod = "Fallback")
    public List<Object[]> openOpportunitiesByIndustry() {
        return contAccOppServiceClient.openOpportunitiesByIndustry();
    }
    @CircuitBreaker(name = "wonOpportunitiesByIndustry", fallbackMethod = "Fallback")
    public List<Object[]> wonOpportunitiesByIndustry() {
        return contAccOppServiceClient.wonOpportunitiesByIndustry();
    }
    @CircuitBreaker(name = "lostOpportunitiesByIndustry", fallbackMethod = "Fallback")
    public List<Object[]> lostOpportunitiesByIndustry(){
        return contAccOppServiceClient.lostOpportunitiesByIndustry();
    }
    public List<Object[]> Fallback(Exception e) {
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");
        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        List<Object[]> list = new ArrayList<>();
        Object[] object = new Object[]{e.getMessage(), e.getCause()};
        list.add(object);
        return list;
    }
    @CircuitBreaker(name = "getMeanEmployeeCount", fallbackMethod = "FallbackDouble")
    public double getMeanEmployeeCount(){
        return contAccOppServiceClient.getMeanEmployeeCount();
    }

    @CircuitBreaker(name = "getMedianEmployeeCount", fallbackMethod = "FallbackBigDecimal")
    public BigDecimal getMedianEmployeeCount(){
        return contAccOppServiceClient.getMedianEmployeeCount();
    }
    @CircuitBreaker(name = "getMaxEmployeeCount", fallbackMethod = "FallbackInt")
    public int getMaxEmployeeCount(){
        return contAccOppServiceClient.getMaxEmployeeCount();
    }
    @CircuitBreaker(name = "getMinEmployeeCount", fallbackMethod = "FallbackInt")
    public int getMinEmployeeCount(){
        return contAccOppServiceClient.getMinEmployeeCount();
    }
    @CircuitBreaker(name = "getMeanQuantityOfProducts", fallbackMethod = "FallbackDouble")
    public double getMeanQuantityOfProducts(){
        return contAccOppServiceClient.getMeanQuantityOfProducts();
    }
    @CircuitBreaker(name = "getMedianQuantityOfProducts", fallbackMethod = "FallbackBigDecimal")
    public BigDecimal getMedianQuantityOfProducts(){
        return contAccOppServiceClient.getMedianQuantityOfProducts();
    }

    @CircuitBreaker(name = "getMaxQuantityOfProducts", fallbackMethod = "FallbackInt")
    public int getMaxQuantityOfProducts(){
        return contAccOppServiceClient.getMaxQuantityOfProducts();
    }
    @CircuitBreaker(name = "getMinQuantityOfProducts", fallbackMethod = "FallbackInt")
    public int getMinQuantityOfProducts(){
        return contAccOppServiceClient.getMinQuantityOfProducts();
    }
    @CircuitBreaker(name = "getMeanOpportunitiesPerAccount", fallbackMethod = "FallbackDouble")
    public double getMeanOpportunitiesPerAccount(){
        return contAccOppServiceClient.getMeanOpportunitiesPerAccount();
    }
    @CircuitBreaker(name = "getMedianOpportunitiesPerAccount", fallbackMethod = "FallbackBigDecimal")
    public BigDecimal getMedianOpportunitiesPerAccount() {
        return contAccOppServiceClient.getMedianOpportunitiesPerAccount();
    }
    @CircuitBreaker(name = "getMaxOpportunitiesPerAccount", fallbackMethod = "FallbackInt")
    public int getMaxOpportunitiesPerAccount() {
        return contAccOppServiceClient.getMaxOpportunitiesPerAccount();
    }
    @CircuitBreaker(name = "getMinOpportunitiesPerAccount", fallbackMethod = "FallbackInt")
    public int getMinOpportunitiesPerAccount(){
        return contAccOppServiceClient.getMinOpportunitiesPerAccount();
    }

    public int FallbackInt(Exception e){
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");
        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return 0;
    }

    public double FallbackDouble(Exception e){
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");
        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return 0.00;
    }

    public BigDecimal FallbackBigDecimal(Exception e){
        logger.error(e.getMessage());
        logger.error(e.getClass() + "");
        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new BigDecimal(0);
    }
}
