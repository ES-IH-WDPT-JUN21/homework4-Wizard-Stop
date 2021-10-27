package com.ironhack.opportunityservice.model;

import com.ironhack.opportunityservice.enums.Product;
import com.ironhack.opportunityservice.enums.Status;
import com.ironhack.opportunityservice.supportiveClasses.PrintText;

import javax.persistence.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

@Entity
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Product product;
    private int quantity;
    private Long decisionMakerId;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Long salesRepId;
    private Long accountId;

    //Constructor

    public Opportunity() {
    }

    public Opportunity(Product product, int quantity, Long decisionMakerId) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMakerId = decisionMakerId;
        this.status = Status.OPEN;
    }

    public Opportunity(Product product, int quantity, Long decisionMakerId, Status status, Long salesRepId) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMakerId = decisionMakerId;
        this.status = status;
        this.salesRepId = salesRepId;
    }

    public Opportunity(Product product, int quantity, Long decisionMaker, Long salesRep) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMakerId = decisionMakerId;
        this.salesRepId = salesRepId;
        this.status = Status.OPEN;

    }

    public static int getNumberOfTrucks(){

        Scanner scanner = new Scanner(System.in);
        int numberOfTrucks = 0;
        try {
            String lectorComando = scanner.nextLine();
            numberOfTrucks = Integer.parseInt(lectorComando);
        } catch (InputMismatchException e){
            numberOfTrucks = 0;
        }
        catch (NumberFormatException e){
            numberOfTrucks = 0;
        }
        if (numberOfTrucks < 1) {
            PrintText.wrongNumberOfTrucks();
            numberOfTrucks = 0;
        }
        return numberOfTrucks;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunity that = (Opportunity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    ////////////////////////////////GETTERS AND SETTERS//////////////////////


    public void setId(Long id) {
        this.id = id;
    }

    public Long getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Long salesRepId) {
        this.salesRepId = salesRepId;
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

    public Long getDecisionMakerId() {
        return decisionMakerId;
    }

    public void setDecisionMakerId(Long decisionMakerId) {
        this.decisionMakerId = decisionMakerId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }


}
