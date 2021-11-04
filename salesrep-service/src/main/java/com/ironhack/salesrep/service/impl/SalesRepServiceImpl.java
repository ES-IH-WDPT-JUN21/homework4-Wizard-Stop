package com.ironhack.salesrep.service.impl;

import com.ironhack.salesrep.dto.SalesRepDTO;
import com.ironhack.salesrep.model.SalesRep;
import com.ironhack.salesrep.repository.SalesRepRepository;
import com.ironhack.salesrep.service.interfaces.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void addSalesRep(SalesRepDTO salesRepDTO){
        SalesRep salesRep = new SalesRep();
        salesRep.setName(salesRepDTO.getName());
        salesRepRepository.save(salesRep);
    }

    public void changeSalesRep(SalesRepDTO salesRepDTO) {
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(salesRepDTO.getId());
        if(optionalSalesRep.isPresent()){
            SalesRep salesRep = new SalesRep();
            salesRep = optionalSalesRep.get();
            salesRep.setName(salesRepDTO.getName());
            salesRepRepository.save(salesRep);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    public List<SalesRep> getAll(){
        return salesRepRepository.findAll();
    }

}
