package com.ironhack.edgeservice.controller.dto;

import com.ironhack.edgeservice.enums.Industry;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountDTO {
    @NotNull(message = "Id must be provided")
    private Long id;
    @NotNull(message = "Industry must be provided")
    private Industry industry;
    @NotNull(message = "Employee count must be provided")
    private int employeeCount;
    @NotEmpty(message = "City must be provided")
    private String city;
    @NotEmpty(message = "Country must be provided")
    private String country;

    @NotNull(message = "contact Id must be provided")
    private Long contactId;
    @NotNull(message = "Opportunity id must be provided")
    private Long opportunityId;

    public AccountDTO() {
    }

    public AccountDTO(Long id, Industry industry, int employeeCount, String city, String country, Long contactId, Long opportunityId) {
        this.id = id;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contactId = contactId;
        this.opportunityId = opportunityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }
}
