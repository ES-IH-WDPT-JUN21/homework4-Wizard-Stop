package com.ironhack.customerservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ironhack.customerservice.enums.Product;
import com.ironhack.customerservice.enums.Status;

import javax.persistence.*;

@Entity
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Product product;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "decision_maker_id")
    private Contact decisionMaker;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Long salesRepId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

    public Opportunity() {
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, Long salesRepId) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.salesRepId = salesRepId;

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

    public Long getsalesRepId() {
        return salesRepId;
    }

    public void setsalesRepId(Long salesRepId) {
        this.salesRepId = salesRepId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
