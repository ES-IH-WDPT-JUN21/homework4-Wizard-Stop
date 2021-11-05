package com.ironhack.edgeservice.model;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Lead {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private Long salesRep;

    public Lead() {
    }

    public Lead(String name, String phoneNumber, String email, String companyName, Long salesRep) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.salesRep = salesRep;
    }

    public Contact convertLead(){
        Contact contact = new Contact(getName(), getPhoneNumber(), getEmail(), getCompanyName());
        return contact;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(long salesRep) {
        this.salesRep = salesRep;
    }

}
