package com.ironhack.edgeservice.model;
import com.ironhack.edgeservice.enums.Product;
import com.ironhack.edgeservice.enums.Status;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


public class Opportunity {

    private Long id;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;
    private SalesRep salesRep;
    private Account account;

    public Opportunity() {
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = Status.OPEN;
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, SalesRep salesRep) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRep = salesRep;
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, SalesRep salesRep) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.salesRep = salesRep;
        this.status = Status.OPEN;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
