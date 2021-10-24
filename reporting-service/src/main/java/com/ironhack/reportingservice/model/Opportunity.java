package com.ironhack.reportingservice.model;

import com.ironhack.reportingservice.enums.Product;
import com.ironhack.reportingservice.enums.Status;

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

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Opportunity() {
    }


}
