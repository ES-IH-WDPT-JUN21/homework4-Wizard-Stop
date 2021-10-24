package com.ironhack.reportingservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "decisionMaker")
    private List<Opportunity> opportunities;

    public Contact() {
    }


}