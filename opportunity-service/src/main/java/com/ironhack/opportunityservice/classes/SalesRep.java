package com.ironhack.opportunityservice.classes;

import com.ironhack.opportunityservice.supportiveClasses.PrintText;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SalesRep {

    private Long id;
    private String name;


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
            PrintText.wrongIdSalesRep();
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

}
