package com.ironhack.customerservice.controller.interfaces;

import java.util.List;

public interface ReportingController {

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
}
