package com.ironhack.customerservice.controller.impl;

import com.ironhack.customerservice.controller.interfaces.ReportingController;
import com.ironhack.customerservice.service.interfaces.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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

    @GetMapping("/employee_count/mean")
    @ResponseStatus(HttpStatus.OK)
    public double getMeanEmployeeCount() {
        return reportingService.getMeanEmployeeCount();
    }

    @GetMapping("/employee_count/median")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getMedianEmployeeCount() {
        return reportingService.getMedianEmployeeCount();
    }

    @GetMapping("/employee_count/max")
    @ResponseStatus(HttpStatus.OK)
    public int getMaxEmployeeCount() {
        return reportingService.getMaxEmployeeCount();
    }

    @GetMapping("/employee_count/min")
    @ResponseStatus(HttpStatus.OK)
    public int getMinEmployeeCount() {
        return reportingService.getMinEmployeeCount();
    }

    @GetMapping("/quantity_products/mean")
    @ResponseStatus(HttpStatus.OK)
    public double getMeanQuantityOfProducts() {
        return reportingService.getMeanQuantityOfProducts();
    }

    @GetMapping("/quantity_products/median")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getMedianQuantityOfProducts() {
        return reportingService.getMedianQuantityOfProducts();
    }

    @GetMapping("/quantity_products/max")
    @ResponseStatus(HttpStatus.OK)
    public int getMaxQuantityOfProducts() {
        return reportingService.getMaxQuantityOfProducts();
    }

    @GetMapping("/quantity_products/min")
    @ResponseStatus(HttpStatus.OK)
    public int getMinQuantityOfProducts() {
        return reportingService.getMinQuantityOfProducts();
    }

    @GetMapping("/opportunities_account/mean")
    @ResponseStatus(HttpStatus.OK)
    public double getMeanOpportunitiesPerAccount() {
        return reportingService.getMeanOpportunitiesPerAccount();
    }

    @GetMapping("/opportunities_account/median")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getMedianOpportunitiesPerAccount() {
        return reportingService.getMedianOpportunitiesPerAccount();
    }

    @GetMapping("/opportunities_account/max")
    @ResponseStatus(HttpStatus.OK)
    public int getMaxOpportunitiesPerAccount() {
        return reportingService.getMaxOpportunitiesPerAccount();
    }

    @GetMapping("/opportunities_account/min")
    @ResponseStatus(HttpStatus.OK)
    public int getMinOpportunitiesPerAccount() {
        return reportingService.getMinOpportunitiesPerAccount();
    }
}
