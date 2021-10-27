package com.ironhack.opportunityservice.classes;

import com.ironhack.opportunityservice.enums.Industry;
import com.ironhack.opportunityservice.model.Opportunity;
import com.ironhack.opportunityservice.supportiveClasses.PrintText;

import javax.persistence.*;
import java.util.*;

public class Account {
    private Long id;

    @Enumerated(EnumType.STRING)
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;

    // Constructor
    public Account() {
    }

    public Account(Industry industry, int employeeCount, String city, String country) {
        this.industry = industry;
        this.employeeCount = employeeCount;
        setCity(city);
        setCountry(country);
    }

    public static String getCityFromUser(){
        Scanner scanner = new Scanner(System.in);
        String city = "";
        try {
            city = scanner.nextLine();
        } catch (InputMismatchException e){
            city = "";
        }
        return city;
    }

    public static String getCountryFromUser(){
        Scanner scanner = new Scanner(System.in);
        String country = "";
        try {
            country = scanner.nextLine();
        } catch (InputMismatchException e){
            country = "";
        }
        return country;
    }

    public static int getNumberOfEmployees() {

        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = 0;
        try {
            String lectorComando = scanner.nextLine();
            numberOfEmployees = Integer.parseInt(lectorComando);
        } catch (InputMismatchException e){
            numberOfEmployees = 0;
        }
        catch (NumberFormatException e){
            numberOfEmployees = 0;
        }
        if (numberOfEmployees < 1) {
            PrintText.wrongNumberOfEmployees();
            numberOfEmployees = 0;
        }
        return numberOfEmployees;
    }

    public static String getIfCreateNewAccount() {
        Scanner scanner = new Scanner(System.in);
        String newAccount = "";
        try{
            newAccount = scanner.nextLine();
        } catch (InputMismatchException e){
            newAccount= "";
        }
        return newAccount;
    }

    public static Long getIdOfExistingAccount() {
        Scanner scanner = new Scanner(System.in);
        Long idAccount = Long.valueOf(0);
        try {
            String lectorComando = scanner.nextLine();
            idAccount = Long.parseLong(lectorComando);
        } catch (InputMismatchException e){
            idAccount = Long.valueOf(0);
        }
        catch (NumberFormatException e){
            idAccount = Long.valueOf(0);
        }
        if (idAccount < 1) {
            PrintText.wrongNumberIdOfAccount();
            idAccount = Long.valueOf(0);
        }
        return idAccount;

    }

    ////////////////////////////////GETTERS AND SETTERS//////////////////////


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public static String regexCityValidation() {
        String validation = "(?i)(^[a-záéíóúüñç])((?![ .,'-]$)[a-záéíóúüñç .,'-]){0,24}$";
        return validation;
    }

    public Boolean setCity(String city) {
        if (city.matches(regexCityValidation())) {
            this.city = city;
            return true;
        } else {
            throw new IllegalArgumentException("City name format should be valid.");
        }
    }

    public String getCountry() {
        return country;
    }

    public static String regexCountryValidation() {
        String validation = "(?i)(^[a-záéíóúüñç])((?![ .,'-]$)[a-záéíóúüñç .,'-]){0,24}$";
        return validation;
    }

    public Boolean setCountry(String country) {
        if (country.matches(regexCountryValidation())) {
            this.country = country;
            return true;
        } else {
            throw new IllegalArgumentException("Country name format should be valid.");
        }
    }

}
