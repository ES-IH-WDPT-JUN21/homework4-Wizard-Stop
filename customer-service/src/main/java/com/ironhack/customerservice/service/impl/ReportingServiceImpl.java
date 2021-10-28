package com.ironhack.customerservice.service.impl;

import com.ironhack.customerservice.repository.OpportunityRepository;
import com.ironhack.customerservice.service.interfaces.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Override
    public List<Object[]> showOpportunitiesBySalesRep() {
        List<Object[]> report = opportunityRepository.opportunitiesBySalesRep();
        return report;
    }

//    @Override
//    public List<Object[]> showClosedWonOpportunitiesBySalesRep() {
//        List<Object[]> report = opportunityRepository.closedWonOpportunitiesBySalesRep();
//        return report;
//    }
//
//    @Override
//    public List<Object[]> showClosedLostOpportunitiesBySalesRep() {
//        List<Object[]> report = opportunityRepository.closedLostOpportunitiesBySalesRep();
//        return report;
//    }
//
//    @Override
//    public List<Object[]> showOpenOpportunitiesBySalesRep() {
//        List<Object[]> report = opportunityRepository.openOpportunitiesBySalesRep();
//        return report;
//    }
}
