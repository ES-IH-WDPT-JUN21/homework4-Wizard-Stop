package com.ironhack.reportingservice.model;

import javax.persistence.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Entity
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "salesRep", cascade = CascadeType.ALL)
    private List<Lead> leads;

    @OneToMany(mappedBy = "salesRep", cascade = CascadeType.ALL)
    private List<Opportunity> opportunities;

    public SalesRep() {
    }


}
