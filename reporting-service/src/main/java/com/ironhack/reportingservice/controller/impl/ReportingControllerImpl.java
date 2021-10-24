package com.ironhack.reportingservice.controller.impl;

import com.ironhack.reportingservice.controller.interfaces.ReportingController;
import com.ironhack.reportingservice.service.interfaces.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportingControllerImpl implements ReportingController {

    @Autowired
    ReportingService reportingService;

    @GetMapping("/leads_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showLeadsBySalesRep() {
        return reportingService.showLeadsBySalesRep();
    }

    @GetMapping("/opportunities_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showOpportunitiesBySalesRep() {
        return reportingService.showOpportunitiesBySalesRep();
    }

    @GetMapping("/closewon_opportunities_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showClosedWonOpportunitiesBySalesRep() {
        return reportingService.showClosedWonOpportunitiesBySalesRep();
    }

    @GetMapping("/closelost_opportunities_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showClosedLostOpportunitiesBySalesRep() {
        return reportingService.showClosedLostOpportunitiesBySalesRep();
    }

    @GetMapping("/open_opportunities_by_sales_rep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showOpenOpportunitiesBySalesRep() {
        return reportingService.showOpenOpportunitiesBySalesRep();
    }
}
