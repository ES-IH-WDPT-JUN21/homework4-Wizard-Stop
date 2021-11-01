package com.ironhack.salesrep.controller.interfaces;


import com.ironhack.salesrep.dto.SalesRepNameDTO;
import com.ironhack.salesrep.model.SalesRep;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SalesRepController {

    SalesRep getSalesRepById(Long id);

    List<SalesRep> getAllSalesRep();

    void addSalesRep(SalesRepNameDTO salesRepNameDTO);

    void patchSalesRep(Long id, SalesRepNameDTO salesRepNameDTO);

    void deleteSalesRep(Long id);
}
