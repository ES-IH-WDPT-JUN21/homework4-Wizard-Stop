package com.ironhack.customerservice.controller.impl;

import com.ironhack.customerservice.controller.interfaces.ReportingController;
import com.ironhack.customerservice.service.interfaces.ReportingService;
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

    @GetMapping("/opportunities_by_product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> opportunitiesByProduct() {
        return reportingService.opportunitiesByProduct();
    }

    @GetMapping("/open_opportunities_by_product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> openOpportunitiesByProduct() {
        return reportingService.openOpportunitiesByProduct();
    }

    @GetMapping("/closewon_opportunities_by_product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> wonOpportunitiesByProduct() {
        return reportingService.wonOpportunitiesByProduct();
    }

    @GetMapping("/closelost_opportunities_by_product")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> lostOpportunitiesByProduct() {
        return reportingService.lostOpportunitiesByProduct();
    }

    @GetMapping("/opportunities_by_country")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> opportunitiesByCountry() {
        return reportingService.opportunitiesByCountry();
    }

    @GetMapping("/open_opportunities_by_country")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> openOpportunitiesByCountry() {
        return reportingService.openOpportunitiesByCountry();
    }

    @GetMapping("/closewon_opportunities_by_country")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> wonOpportunitiesByCountry() {
        return reportingService.wonOpportunitiesByCountry();
    }

    @GetMapping("/closelost_opportunities_by_country")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> lostOpportunitiesByCountry() {
        return reportingService.lostOpportunitiesByCountry();
    }

    @GetMapping("/opportunities_by_city")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> opportunitiesByCity() {
        return reportingService.opportunitiesByCity();
    }

    @GetMapping("/open_opportunities_by_city")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> openOpportunitiesByCity() {
        return reportingService.openOpportunitiesByCity();
    }

    @GetMapping("/closewon_opportunities_by_city")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> wonOpportunitiesByCity() {
        return reportingService.wonOpportunitiesByCity();
    }

    @GetMapping("/closelost_opportunities_by_city")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> lostOpportunitiesByCity() {
        return reportingService.lostOpportunitiesByCity();
    }

    @GetMapping("/opportunities_by_industry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> opportunitiesByIndustry() {
        return reportingService.opportunitiesByIndustry();
    }

    @GetMapping("/open_opportunities_by_industry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> openOpportunitiesByIndustry() {
        return reportingService.openOpportunitiesByIndustry();
    }

    @GetMapping("/closewon_opportunities_by_industry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> wonOpportunitiesByIndustry() {
        return reportingService.wonOpportunitiesByIndustry();
    }

    @GetMapping("/closelost_opportunities_by_industry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> lostOpportunitiesByIndustry() {
        return reportingService.lostOpportunitiesByIndustry();
    }
}
