package com.ironhack.reportingservice.service.interfaces;

import java.util.List;

public interface ReportingService {
    List<Object[]> showLeadsBySalesRep();
    List<Object[]> showOpportunitiesBySalesRep();
    List<Object[]> showClosedWonOpportunitiesBySalesRep();
    List<Object[]> showClosedLostOpportunitiesBySalesRep();
    List<Object[]> showOpenOpportunitiesBySalesRep();
}
