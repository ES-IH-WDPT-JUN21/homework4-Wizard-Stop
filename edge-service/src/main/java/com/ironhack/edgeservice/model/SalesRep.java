package com.ironhack.edgeservice.model;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SalesRep {

    private Long id;
    private String name;
    private List<Lead> leads;
    private List<Opportunity> opportunities;

    public SalesRep() {
    }

    public SalesRep(String name) {
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }
}
