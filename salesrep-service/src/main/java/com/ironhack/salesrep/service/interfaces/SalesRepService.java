package com.ironhack.salesrep.service.interfaces;

import com.ironhack.salesrep.dto.LeadDTO;
import com.ironhack.salesrep.dto.OpportunityDTO;
import com.ironhack.salesrep.dto.SalesRepNameDTO;
import com.ironhack.salesrep.exceptions.ExistentElementException;
import com.ironhack.salesrep.model.Lead;
import com.ironhack.salesrep.model.Opportunity;
import com.ironhack.salesrep.model.SalesRep;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

public interface SalesRepService {
    void save(SalesRep salesRep) throws ExistentElementException;

    SalesRep findById(Long id) throws InvalidParameterException, NoSuchElementException;

    void delete(Long id) throws InvalidParameterException, NoSuchElementException;

    void addSalesRep(SalesRepNameDTO salesRepNameDTO);

    void changeSalesRep(Long id, SalesRepNameDTO salesRepNameDTO);

    void addLead(LeadDTO leadDTO);

    void addOpportunity(OpportunityDTO opportunityDTO);

    List<Lead> leadsBySalesRep(Long id);

    List<Opportunity> opportunitiesBySalesRep(Long id);

    List<Object[]> reportLeadsBySalesRep();

    List<Object[]> reportOpportunityBySalesRep();


    List<Object[]> reportClosedWonBySalesRep();

    List<Object[]> reportClosedLostBySalesRep();

    List<Object[]> reportOpenBySalesRep();


    SalesRep createSalesRep();

    List<SalesRep> getAll();

    List<Object[]> showLeadsBySalesRep();
    List<Object[]> showOpportunitiesBySalesRep();
    List<Object[]> showClosedWonOpportunitiesBySalesRep();
    List<Object[]> showClosedLostOpportunitiesBySalesRep();
    List<Object[]> showOpenOpportunitiesBySalesRep();
}
