package com.ironhack.opportunityservice.controller.DTO;

import com.ironhack.opportunityservice.enums.Product;
import com.ironhack.opportunityservice.enums.Status;

public class OpportunityDTO {
    private Long id;
    private Product product;
    private int quantity;
    private Status status;
    private Long salesRepId;
    private Long accountId;
    private Long decisionMakerId;

    public OpportunityDTO() {
    }

    public OpportunityDTO(Long id, Product product, int quantity, Status status, Long salesRepId, Long accountId, Long decisionMakerId) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
        this.salesRepId = salesRepId;
        this.accountId = accountId;
        this.decisionMakerId = decisionMakerId;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Long salesRepId) {
        this.salesRepId = salesRepId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getDecisionMakerId() {
        return decisionMakerId;
    }

    public void setDecisionMakerId(Long decisionMakerId) {
        this.decisionMakerId = decisionMakerId;
    }
}
