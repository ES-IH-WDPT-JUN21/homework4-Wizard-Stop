package com.ironhack.customerservice.service.impl;

import com.ironhack.customerservice.repository.AccountRepository;
import com.ironhack.customerservice.repository.OpportunityRepository;
import com.ironhack.customerservice.service.interfaces.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Object[]> showOpportunitiesBySalesRep() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.opportunitiesBySalesRep();
    }

    @Override
    public List<Object[]> showClosedWonOpportunitiesBySalesRep() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.closedWonOpportunitiesBySalesRep();
    }

    @Override
    public List<Object[]> showClosedLostOpportunitiesBySalesRep() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.closedLostOpportunitiesBySalesRep();
    }

    @Override
    public List<Object[]> showOpenOpportunitiesBySalesRep() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.openOpportunitiesBySalesRep();
    }

    @Override
    public List<Object[]> opportunitiesByProduct() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.opportunitiesByProduct();
    }

    @Override
    public List<Object[]> openOpportunitiesByProduct() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.openOpportunitiesByProduct();
    }

    @Override
    public List<Object[]> wonOpportunitiesByProduct() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.wonOpportunitiesByProduct();
    }

    @Override
    public List<Object[]> lostOpportunitiesByProduct() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.lostOpportunitiesByProduct();
    }

    @Override
    public List<Object[]> opportunitiesByCountry() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.opportunitiesByCountry();
    }

    @Override
    public List<Object[]> openOpportunitiesByCountry() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.openOpportunitiesByCountry();
    }

    @Override
    public List<Object[]> wonOpportunitiesByCountry() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.wonOpportunitiesByCountry();
    }

    @Override
    public List<Object[]> lostOpportunitiesByCountry() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.lostOpportunitiesByCountry();
    }

    @Override
    public List<Object[]> opportunitiesByCity() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.opportunitiesByCity();
    }

    @Override
    public List<Object[]> openOpportunitiesByCity() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.openOpportunitiesByCity();
    }

    @Override
    public List<Object[]> wonOpportunitiesByCity() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.wonOpportunitiesByCity();
    }

    @Override
    public List<Object[]> lostOpportunitiesByCity() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.lostOpportunitiesByCity();
    }

    @Override
    public List<Object[]> opportunitiesByIndustry() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.opportunitiesByIndustry();
    }

    @Override
    public List<Object[]> openOpportunitiesByIndustry() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.openOpportunitiesByIndustry();
    }

    @Override
    public List<Object[]> wonOpportunitiesByIndustry() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.wonOpportunitiesByIndustry();
    }

    @Override
    public List<Object[]> lostOpportunitiesByIndustry() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.lostOpportunitiesByIndustry();
    }

    @Override
    public double getMeanEmployeeCount() {
        if(accountRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no accounts");
        }
        return opportunityRepository.getMeanEmployeeCount();
    }

    @Override
    public BigDecimal getMedianEmployeeCount() {
        if(accountRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no accounts");
        }
        opportunityRepository.setRowIndex();
        return (BigDecimal) opportunityRepository.getMedianEmployeeCount().get(0)[0];

    }

    @Override
    public int getMaxEmployeeCount() {
        if(accountRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no accounts");
        }
        return opportunityRepository.getMaxEmployeeCount();
    }

    @Override
    public int getMinEmployeeCount() {
        if(accountRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no accounts");
        }
        return opportunityRepository.getMinEmployeeCount();
    }

    @Override
    public double getMeanQuantityOfProducts() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.getMeanQuantityOfProducts();
    }

    @Override
    public BigDecimal getMedianQuantityOfProducts() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        opportunityRepository.setRowIndex();
        return (BigDecimal) opportunityRepository.getMedianQuantityOfProducts().get(0)[0];
    }

    @Override
    public int getMaxQuantityOfProducts() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.getMaxQuantityOfProducts();
    }

    @Override
    public int getMinQuantityOfProducts() {
        if(opportunityRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no opportunities");
        }
        return opportunityRepository.getMinQuantityOfProducts();
    }

    @Override
    public double getMeanOpportunitiesPerAccount() {
        if(accountRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no accounts");
        }
        return opportunityRepository.getMeanOpportunitiesPerAccount();
    }

    @Override
    public BigDecimal getMedianOpportunitiesPerAccount() {
        if(accountRepository.findAll().size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no accounts");
        }
        opportunityRepository.setRowIndex();
        return (BigDecimal) opportunityRepository.getMedianOpportunitiesPerAccount().get(0)[0];
    }

    @Override
    public int getMaxOpportunitiesPerAccount() {
        if(accountRepository.findAll().size() == 0){
            throw new IllegalStateException();
        }
        return opportunityRepository.getMaxOpportunitiesPerAccount();
    }

    @Override
    public int getMinOpportunitiesPerAccount() {
        if(accountRepository.findAll().size() == 0){
            throw new IllegalStateException();
        }
        return opportunityRepository.getMinOpportunitiesPerAccount();
    }
}
