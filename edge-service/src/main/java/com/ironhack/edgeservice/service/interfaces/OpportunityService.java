package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.exceptions.ExistentElementException;
import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.model.Contact;
import com.ironhack.edgeservice.model.Opportunity;
import com.ironhack.edgeservice.model.SalesRep;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface OpportunityService {
    Opportunity findById(Long id);

    void delete(Long id) throws InvalidParameterException, NoSuchElementException;

    Opportunity save(OpportunityDTO opportunity);

    Account findAccountByOpportunity(Opportunity opportunity) throws NoSuchElementException;

    List<Opportunity> getAll();

    Opportunity obtainOpportunity(Contact contact, SalesRep salesRep);

    String closeLost(Long id);

    String closeWon(Long id);

    List<Object[]> showOpportunitiesBySalesRep();
    List<Object[]> showClosedWonOpportunitiesBySalesRep();
    List<Object[]> showClosedLostOpportunitiesBySalesRep();
    List<Object[]> showOpenOpportunitiesBySalesRep();
    List<Object[]> opportunitiesByProduct();
    List<Object[]> openOpportunitiesByProduct();
    List<Object[]> wonOpportunitiesByProduct();
    List<Object[]> lostOpportunitiesByProduct();
    List<Object[]> opportunitiesByCountry();
    List<Object[]> openOpportunitiesByCountry();
    List<Object[]> wonOpportunitiesByCountry();
    List<Object[]> lostOpportunitiesByCountry();
    List<Object[]> opportunitiesByCity();
    List<Object[]> openOpportunitiesByCity();
    List<Object[]> wonOpportunitiesByCity();
    List<Object[]> lostOpportunitiesByCity();
    List<Object[]> opportunitiesByIndustry();
    List<Object[]> openOpportunitiesByIndustry();
    List<Object[]> wonOpportunitiesByIndustry();
    List<Object[]> lostOpportunitiesByIndustry();
    double getMeanEmployeeCount();
    BigDecimal getMedianEmployeeCount();
    int getMaxEmployeeCount();
    int getMinEmployeeCount();
    double getMeanQuantityOfProducts();
    BigDecimal getMedianQuantityOfProducts();
    int getMaxQuantityOfProducts();
    int getMinQuantityOfProducts();
    double getMeanOpportunitiesPerAccount();
    BigDecimal getMedianOpportunitiesPerAccount();
    int getMaxOpportunitiesPerAccount();
    int getMinOpportunitiesPerAccount();
}
