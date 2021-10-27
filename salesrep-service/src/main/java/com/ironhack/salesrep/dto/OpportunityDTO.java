package com.ironhack.salesrep.dto;

import com.ironhack.salesrep.enums.Product;
import com.ironhack.salesrep.enums.Status;

import javax.persistence.*;

public class OpportunityDTO {
    private Long id;
    private String product;
    private int quantity;
    //contact
    private Long decisionMaker;
    private String status;
    private Long salesRep;
    private Long account;
    private Long deletedLead;

    public Long getDeletedLead() {
        return deletedLead;
    }

    public void setDeletedLead(Long deletedLead) {
        this.deletedLead = deletedLead;
    }

    public OpportunityDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Long decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Long salesRep) {
        this.salesRep = salesRep;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }
}
