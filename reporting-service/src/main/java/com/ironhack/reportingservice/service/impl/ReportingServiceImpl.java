package com.ironhack.reportingservice.service.impl;

import com.ironhack.reportingservice.repository.SalesRepRepository;
import com.ironhack.reportingservice.service.interfaces.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService {

    @Autowired
    SalesRepRepository salesRepRepository;
    @Override
    public List<Object[]> showLeadsBySalesRep() {
        List<Object[]> report = salesRepRepository.leadBySalesRep();
        return report;
    }

    @Override
    public List<Object[]> showOpportunitiesBySalesRep() {
        List<Object[]> report = salesRepRepository.opportunitiesBySalesRep();
        return report;
    }

    @Override
    public List<Object[]> showClosedWonOpportunitiesBySalesRep() {
        List<Object[]> report = salesRepRepository.closedWonOpportunitiesBySalesRep();
        return report;
    }

    @Override
    public List<Object[]> showClosedLostOpportunitiesBySalesRep() {
        List<Object[]> report = salesRepRepository.closedLostOpportunitiesBySalesRep();
        return report;
    }

    @Override
    public List<Object[]> showOpenOpportunitiesBySalesRep() {
        List<Object[]> report = salesRepRepository.openOpportunitiesBySalesRep();
        return report;
    }
}
