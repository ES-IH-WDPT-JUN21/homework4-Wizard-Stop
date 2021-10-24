package com.ironhack.reportingservice.model;

import javax.persistence.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

@Entity
@Table(name="`lead`")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public Lead() {
    }

}
