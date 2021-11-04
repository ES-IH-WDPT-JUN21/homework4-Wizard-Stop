package com.ironhack.salesrep.controller.interfaces;


import com.ironhack.salesrep.dto.SalesRepDTO;
import com.ironhack.salesrep.model.SalesRep;

import java.util.List;

public interface SalesRepController {

    SalesRep getSalesRepById(Long id);

    List<SalesRep> getAllSalesRep();

    void addSalesRep(SalesRepDTO salesRepDTO);

    void updateSalesRep(SalesRepDTO salesRepDTO);

    void deleteSalesRep(Long id);
}
