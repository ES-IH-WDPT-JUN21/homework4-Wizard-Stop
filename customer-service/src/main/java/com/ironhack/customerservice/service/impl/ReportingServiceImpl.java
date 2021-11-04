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
        return opportunityRepository.opportunitiesBySalesRep();
    }

    @Override
    public List<Object[]> showClosedWonOpportunitiesBySalesRep() {
        return opportunityRepository.closedWonOpportunitiesBySalesRep();
    }

    @Override
    public List<Object[]> showClosedLostOpportunitiesBySalesRep() {
        return opportunityRepository.closedLostOpportunitiesBySalesRep();
    }

    @Override
    public List<Object[]> showOpenOpportunitiesBySalesRep() {
        return opportunityRepository.openOpportunitiesBySalesRep();
    }

    @Override
    public List<Object[]> opportunitiesByProduct() {
        return opportunityRepository.opportunitiesByProduct();
    }

    @Override
    public List<Object[]> openOpportunitiesByProduct() {
        return opportunityRepository.openOpportunitiesByProduct();
    }

    @Override
    public List<Object[]> wonOpportunitiesByProduct() {
        List<Object[]> report = opportunityRepository.wonOpportunitiesByProduct();
        return report;
    }

    @Override
    public List<Object[]> lostOpportunitiesByProduct() {
        return opportunityRepository.lostOpportunitiesByProduct();
    }

    @Override
    public List<Object[]> opportunitiesByCountry() {
        return opportunityRepository.opportunitiesByCountry();
    }

    @Override
    public List<Object[]> openOpportunitiesByCountry() {
        return opportunityRepository.openOpportunitiesByCountry();
    }

    @Override
    public List<Object[]> wonOpportunitiesByCountry() {
        return opportunityRepository.wonOpportunitiesByCountry();
    }

    @Override
    public List<Object[]> lostOpportunitiesByCountry() {
        return opportunityRepository.lostOpportunitiesByCountry();
    }

    @Override
    public List<Object[]> opportunitiesByCity() {
        return opportunityRepository.opportunitiesByCity();
    }

    @Override
    public List<Object[]> openOpportunitiesByCity() {
        return opportunityRepository.openOpportunitiesByCity();
    }

    @Override
    public List<Object[]> wonOpportunitiesByCity() {
        return opportunityRepository.wonOpportunitiesByCity();
    }

    @Override
    public List<Object[]> lostOpportunitiesByCity() {
        return opportunityRepository.lostOpportunitiesByCity();
    }

    @Override
    public List<Object[]> opportunitiesByIndustry() {
        return opportunityRepository.opportunitiesByIndustry();
    }

    @Override
    public List<Object[]> openOpportunitiesByIndustry() {
        return opportunityRepository.openOpportunitiesByIndustry();
    }

    @Override
    public List<Object[]> wonOpportunitiesByIndustry() {
        return opportunityRepository.wonOpportunitiesByIndustry();
    }

    @Override
    public List<Object[]> lostOpportunitiesByIndustry() {
        return opportunityRepository.lostOpportunitiesByIndustry();
    }
}
