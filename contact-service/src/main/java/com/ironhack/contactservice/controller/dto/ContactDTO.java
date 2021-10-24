package com.ironhack.contactservice.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ContactDTO {

    @NotEmpty(message = "Name must be provided")
    private String name;
    @NotEmpty(message = "Phone number must be provided")
    private String phoneNumber;
    @NotEmpty(message = "Email must be provided")
    @Email
    private String email;
    @NotEmpty(message = "Name must be provided")
    private String companyName;
    private Long accountId;


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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

}
