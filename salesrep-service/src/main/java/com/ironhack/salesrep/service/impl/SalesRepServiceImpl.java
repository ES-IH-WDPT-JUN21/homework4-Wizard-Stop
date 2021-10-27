package com.ironhack.salesrep.service.impl;

import com.ironhack.salesrep.dto.LeadDTO;
import com.ironhack.salesrep.dto.OpportunityDTO;
import com.ironhack.salesrep.dto.SalesRepNameDTO;
import com.ironhack.salesrep.enums.Product;
import com.ironhack.salesrep.enums.Status;
import com.ironhack.salesrep.exceptions.ExistentElementException;
import com.ironhack.salesrep.model.Lead;
import com.ironhack.salesrep.model.Opportunity;
import com.ironhack.salesrep.model.SalesRep;
import com.ironhack.salesrep.repository.LeadRepository;
import com.ironhack.salesrep.repository.OpportunityRepository;
import com.ironhack.salesrep.repository.SalesRepRepository;
import com.ironhack.salesrep.service.interfaces.SalesRepService;
import com.ironhack.salesrep.supportiveClasses.PrintText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OperatorPower;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SalesRepServiceImpl implements SalesRepService {

    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    public void save(SalesRep salesRep) throws ExistentElementException {
        if (salesRep.getId() != null) {
            if (salesRep.getId() < 1)
                throw new InvalidParameterException();
            Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(salesRep.getId());
            if (optionalSalesRep.isPresent()) {
                throw new ExistentElementException("The ID " + salesRep.getId() + " already exists in the SalesRep Database");
            } else {
                salesRepRepository.save(salesRep);
            }
        } else {
            salesRepRepository.save(salesRep);
        }
    }

    public SalesRep findById(Long id) throws InvalidParameterException, NoSuchElementException {
        if (id < 1)
            throw new InvalidParameterException();
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(id);
        if (optionalSalesRep.isPresent()) {
            return optionalSalesRep.get();
        }
        else
            throw new NoSuchElementException("The ID " + id + " does not match with any SalesRep");
    }

    public void delete(Long id) throws InvalidParameterException, NoSuchElementException {
        if (id < 1)
            throw new InvalidParameterException();
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(id);
        //Según el diagrama de clases, cuando se borra un salesRep se borran sus lead y sus opportunities
        if (optionalSalesRep.isPresent()) {
            salesRepRepository.delete(optionalSalesRep.get());
        }
        else
            throw new NoSuchElementException("The ID " + id + " does not match with any SalesRep");
    }

    public void addSalesRep(SalesRepNameDTO salesRepNameDTO){
        SalesRep salesRep = new SalesRep();
        salesRep.setName(salesRepNameDTO.getName());
        salesRepRepository.save(salesRep);
    }

    public void changeSalesRep(Long id, SalesRepNameDTO salesRepNameDTO) {
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(id);
        if(optionalSalesRep.isPresent()){
            SalesRep salesRep = new SalesRep();
            salesRep = optionalSalesRep.get();
            salesRep.setName(salesRepNameDTO.getName());
            salesRepRepository.save(salesRep);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    public void addLead(LeadDTO leadDTO) {
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(leadDTO.getSalesRep());
        if(optionalSalesRep.isPresent()){
            for(int i = 0; i<optionalSalesRep.get().getLeads().size(); i++){
                if(optionalSalesRep.get().getLeads().get(i).getId() == leadDTO.getId()){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lead with id " + leadDTO.getId() + " already belongs to SalesRep with id " + leadDTO.getSalesRep());
                }
            }

            SalesRep salesRep = optionalSalesRep.get();

            Lead lead = new Lead();
            lead.setId(leadDTO.getId());
            lead.setName(leadDTO.getName());
            lead.setPhoneNumber(leadDTO.getPhoneNumber());
            lead.setEmail(leadDTO.getEmail());
            lead.setCompanyName(leadDTO.getCompanyName());
            lead.setSalesRep(salesRep);

            leadRepository.save(lead);
            salesRep.addLead(lead);
            salesRepRepository.save(salesRep);

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void addOpportunity(OpportunityDTO opportunityDTO) {

        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(opportunityDTO.getSalesRep());
        if(optionalSalesRep.isPresent()){
            for(int i = 0; i<optionalSalesRep.get().getLeads().size(); i++){
                if(optionalSalesRep.get().getLeads().get(i).getId() == opportunityDTO.getId()){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Opportunity with id " + opportunityDTO.getId() + " already belongs to SalesRep with id " + opportunityDTO.getSalesRep());
                }
            }

            SalesRep salesRep =  optionalSalesRep.get();

            Opportunity opportunity = new Opportunity();

            opportunity.setId(opportunityDTO.getId());
            opportunity.setProduct(Product.valueOf(opportunityDTO.getProduct()));
            opportunity.setQuantity(opportunityDTO.getQuantity());
            opportunity.setDecisionMaker(opportunityDTO.getDecisionMaker());
            opportunity.setStatus(Status.valueOf(opportunityDTO.getStatus()));
            opportunity.setSalesRep(salesRep);
            opportunity.setAccount(opportunityDTO.getAccount());

            //TODO: le meti deletedlead al opportunity

            Optional<Lead> optionalLead = leadRepository.findById(opportunityDTO.getDeletedLead());
            if(optionalLead.isPresent()){
                Lead leadToBeDeleted = optionalLead.get();
                leadRepository.delete(leadToBeDeleted);
            }

            opportunityRepository.save(opportunity);
            salesRep.addOpportunity(opportunity);
            salesRepRepository.save(salesRep);

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Lead> leadsBySalesRep(Long id) {
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(id);
        if(optionalSalesRep.isPresent()){
            return optionalSalesRep.get().getLeads();

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Opportunity> opportunitiesBySalesRep(Long id) {
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(id);
        if(optionalSalesRep.isPresent()){
            return optionalSalesRep.get().getOpportunities();

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Object[]> reportLeadsBySalesRep() {
        return salesRepRepository.leadBySalesRep();
    }

    public List<Object[]> reportOpportunityBySalesRep() {
        return salesRepRepository.opportunitiesBySalesRep();
    }

    public List<Object[]> reportClosedWonBySalesRep() {
            return salesRepRepository.closedWonOpportunitiesBySalesRep();
    }

    public List<Object[]> reportClosedLostBySalesRep() {
        return salesRepRepository.closedLostOpportunitiesBySalesRep();
    }

    public List<Object[]> reportOpenBySalesRep() {
        return salesRepRepository.openOpportunitiesBySalesRep();
    }


    public SalesRep createSalesRep() {
        //get name from user
        String name = "";
        do{
            PrintText.askSalesRepName();
            String initialName = SalesRep.getNameFromUser();
            if(initialName.matches((SalesRep.regexNameValidation()))) {
                name = initialName;
            } else {
                name = "";
                PrintText.invalidName();
            }
        } while ("".equals(name));


        SalesRep newSalesRep = new SalesRep(name);

        return newSalesRep;
    }

    public List<SalesRep> getAll(){
        return salesRepRepository.findAll();
    }

    public List<Object[]> showLeadsBySalesRep(){ return salesRepRepository.leadBySalesRep();}
    public List<Object[]> showOpportunitiesBySalesRep(){return salesRepRepository.opportunitiesBySalesRep();}
    public List<Object[]> showClosedWonOpportunitiesBySalesRep(){return salesRepRepository.closedWonOpportunitiesBySalesRep();}
    public List<Object[]> showClosedLostOpportunitiesBySalesRep(){return salesRepRepository.closedLostOpportunitiesBySalesRep();}
    public List<Object[]> showOpenOpportunitiesBySalesRep(){return salesRepRepository.openOpportunitiesBySalesRep();}
}
