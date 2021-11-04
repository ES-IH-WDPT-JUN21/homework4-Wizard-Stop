package com.ironhack.edgeservice.controller.dto;

import com.ironhack.edgeservice.enums.Product;
import com.ironhack.edgeservice.enums.Status;

import javax.validation.constraints.NotNull;

public class OpportunityDTO {
    @NotNull
    private Product product;
    @NotNull
    private int quantity;
    @NotNull
    private Status status;
    @NotNull
    private Long salesRepId;
    @NotNull
    private Long accountId;
    @NotNull
    private Long decisionMakerId;
    public OpportunityDTO() {
    }

    public OpportunityDTO(Product product, int quantity, Status status, Long salesRepId, Long accountId, Long decisionMakerId) {
        this.product = product;
        this.quantity = quantity;
        this.status = status;
        this.salesRepId = salesRepId;
        this.accountId = accountId;
        this.decisionMakerId = decisionMakerId;
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
