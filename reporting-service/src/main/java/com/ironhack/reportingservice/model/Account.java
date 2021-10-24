package com.ironhack.reportingservice.model;


import com.ironhack.reportingservice.enums.Industry;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Opportunity> opportunities;

    // Constructor
    public Account() {
    }


}
