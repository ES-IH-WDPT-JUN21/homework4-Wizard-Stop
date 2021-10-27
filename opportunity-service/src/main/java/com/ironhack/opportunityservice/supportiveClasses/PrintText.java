package com.ironhack.opportunityservice.supportiveClasses;

public class PrintText {

    public static void wrongNumberOfTrucks() {
        System.out.println(Colors.RESET+Colors.LIGHT_RED+ "Insert a number of trucks bigger than zero");
    }

    public static void wrongNumberOfEmployees() {
        System.out.println(Colors.RESET+Colors.LIGHT_RED+ "Insert a number of employees bigger than zero");
    }

    public static void wrongNumberIdOfAccount() {
        System.out.println(Colors.RESET+Colors.LIGHT_RED+ "Insert an Account id bigger than zero");
    }

    public static void wrongIdSalesRep() {
        System.out.println(Colors.RESET+Colors.LIGHT_RED+ "Insert a SalesRep id bigger than zero");
    }

}
