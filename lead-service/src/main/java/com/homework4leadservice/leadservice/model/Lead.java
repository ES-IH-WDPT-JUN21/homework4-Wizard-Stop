package com.homework4leadservice.leadservice.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
@Entity
@Table(name="`lead`")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @NotEmpty
    private String name;
    @Valid
    @NotEmpty
    private String phoneNumber;
    @Email
    @NotEmpty
    private String email;
    @Valid
    @NotEmpty
    private String companyName;
    @Column(name = "sales_rep_id")
    @NotNull
    private Long salesRep;

    ////////////CONSTRUCTORS////////////


    public Lead() {
    }

    public Lead(Long id, String name, String phoneNumber, String email, String companyName, Long salesRep) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.salesRep = salesRep;
    }

    ////////////////////////////////GETTERS AND SETTERS//////////////////////

    public Long getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Long salesRep) {
        this.salesRep = salesRep;
    }

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

    public static String getPhoneNumberFromUser(){
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = "";
        try{
            phoneNumber = scanner.nextLine();
        } catch (InputMismatchException e){
            phoneNumber= "";
        }

        return phoneNumber;
    }

    public static String getEmailFromUser(){
        Scanner scanner = new Scanner(System.in);
        String email = "";
        try{
            email = scanner.nextLine();
        } catch (InputMismatchException e){
            email= "";
        }

        return email;
    }

    public static String getCompanyNameFromUser(){
        Scanner scanner = new Scanner(System.in);
        String companyName = "";
        try {

            companyName = scanner.nextLine();
        } catch (InputMismatchException e){
            companyName= "";
        }

        return companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return id == lead.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    ////////////////////////////////GETTERS AND SETTERS//////////////////////

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static String regexPhoneNumberValidation(){
        String validation = "^[+]*[(]{0,1}[+]*[0-9]{1,4}[)]{0,1}[0-9]{8,9}";
        return validation;
    }

    public Boolean setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches(regexPhoneNumberValidation())) {
            this.phoneNumber = phoneNumber;
            return true;
        } else {
            throw new IllegalArgumentException("Phone number format should be valid.");
        }
    }

    public String getEmail() {
        return email;
    }

    public static String regexEmailValidation(){
        String validation = "(?i:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\" +
                "x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@" +
                "(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4]" +
                "[0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\" +
                "x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        return validation;
    }

    public boolean setEmail(String email) {
//      RFC 5322 Official Standard
        if (email.matches(regexEmailValidation())) {
            this.email = email;
            return true;
        } else {
            throw new IllegalArgumentException("Email format should be valid");
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public static String regexCompanyNameValidation() {
        String validation = "(?i)(^[a-záéíóúüñç0-9])((?![ .,'-]$)[a-záéíóúüñç0-9 .,'-]){0,24}$";
        return validation;
    }

    public Boolean setCompanyName(String companyName) {
        if(companyName.matches(regexCompanyNameValidation())) {
            this.companyName = companyName;
            return true;
        } else {
            throw new IllegalArgumentException("Company name format should be valid.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}