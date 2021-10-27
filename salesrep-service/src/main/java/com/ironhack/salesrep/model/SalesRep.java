package com.ironhack.salesrep.model;


import com.ironhack.salesrep.supportiveClasses.Colors;

import javax.persistence.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Entity
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "salesRep")
    private List<Lead> leads;

    @OneToMany(mappedBy = "salesRep")
    private List<Opportunity> opportunities;

    // Constructor

    public SalesRep() {
    }

    public SalesRep(String name) {
        setName(name);
    }

    //////////////////////////APPLICABLE METHODS/////////////////

    public static String getNameFromUser(){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        try {

            name = scanner.nextLine();
        } catch (InputMismatchException e){
            name= "";
        }

        return name;
    }

    public static Long getSalesRepIdFromCommand(){

        Scanner scanner = new Scanner(System.in);
        Long salesRepId = Long.valueOf(0);
        try {
            String lectorComando = scanner.nextLine();
            salesRepId = Long.parseLong(lectorComando);
        } catch (InputMismatchException e){
            salesRepId = Long.valueOf(0);
        }
        catch (NumberFormatException e){
            salesRepId = Long.valueOf(0);
        }
        if (salesRepId < 1) {
            wrongIdSalesRep();
            salesRepId = Long.valueOf(0);
        }
        return salesRepId;

    }


    ////////////////////////////////GETTERS AND SETTERS//////////////////////


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String regexNameValidation() {
        String validation = "(?i)(^[a-záéíóúüñç])((?![ .,'-]$)[a-záéíóúüñç .,'-]){0,24}$";
        return validation;
    }

    public Boolean setName(String name) {
        if(name.matches(regexNameValidation())) {
            this.name = name;
            return true;
        } else {
            throw new IllegalArgumentException("Name format should be valid.");
        }
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public void addLead(Lead lead){
        leads.add(lead);
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void addOpportunity(Opportunity opportunity){
        opportunities.add(opportunity);
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public String toStringFormatted() {
        return  "ID " + id +
                " | Name: " + name;
    }

    public static void wrongIdSalesRep() {
        System.out.println(Colors.RESET+Colors.LIGHT_RED+ "Insert a SalesRep id bigger than zero");
    }
}
