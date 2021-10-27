package com.ironhack.customerservice.controller.interfaces;

import java.util.List;

public interface ReportingController {
    List<Object[]> showLeadsBySalesRep();
    List<Object[]> showOpportunitiesBySalesRep();
    List<Object[]> showClosedWonOpportunitiesBySalesRep();
    List<Object[]> showClosedLostOpportunitiesBySalesRep();
    List<Object[]> showOpenOpportunitiesBySalesRep();
}
