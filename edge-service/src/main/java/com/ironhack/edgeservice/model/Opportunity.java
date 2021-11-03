package com.ironhack.edgeservice.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Long salesRepId;
    private Account account;

    public Opportunity() {
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = Status.OPEN;
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, Long salesRepId) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRepId = salesRepId;
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, Long salesRepId ) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.salesRepId = salesRepId;
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

    public Long getSalesRep() {
        return salesRepId;
    }

    public void setSalesRep(Long salesRep) {
        this.salesRepId = salesRepId;
    }

//    public Account getAccount() {
//        return account;
//    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
