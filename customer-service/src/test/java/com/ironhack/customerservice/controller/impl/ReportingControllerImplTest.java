package com.ironhack.customerservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.customerservice.enums.Industry;
import com.ironhack.customerservice.enums.Product;
import com.ironhack.customerservice.enums.Status;
import com.ironhack.customerservice.model.*;
import com.ironhack.customerservice.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ReportingControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();


    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    private Contact contact4;
    private Contact contact5;
    private Contact contact6;
    private Contact contact7;
    private Contact contact8;

    private Account account1;
    private Account account2;
    private Account account3;
    private Account account4;
    private Account account5;
    private Account account6;

    private Opportunity opportunity1;
    private Opportunity opportunity2;
    private Opportunity opportunity3;
    private Opportunity opportunity4;
    private Opportunity opportunity5;
    private Opportunity opportunity6;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        account1 = new Account(Industry.ECOMMERCE, 25, "Madrid", "España");
        account2 = new Account(Industry.MANUFACTURING, 150, "Ankara", "Turquía");
        account3 = new Account(Industry.MEDICAL, 2500, "Wuhan", "China");
        account4 = new Account(Industry.ECOMMERCE, 120, "Berlin", "Alemania");
        account5 = new Account(Industry.OTHER, 78, "Frankfurt", "Alemania");
        account6 = new Account(Industry.OTHER, 250, "Londres", "Inglaterra");

        contact1 = new Contact("Diego Ruiz","666123123","diegoruiz@gmail.com","Zalando");
        contact2 = new Contact("Abel Ruiz","666234234","abelruiz@gmail.com","Zalando");
        contact3 = new Contact("Pepe Pérez", "888999000", "pepepere@gmail.com", "Manufacturas Perez");
        contact4 = new Contact("Manolo Bacteria","666999777","manolobacteria@gmail.com","Norton Antivirus");
        contact5 = new Contact("Ricardo Virus","666999666","ricardovirus@gmail.com","Norton Antivirus");
        contact6 = new Contact("Gunther Fragher","333999666","guntherfragher@gmail.com","Ebay");
        contact7 = new Contact("Anna Müller","333555666","annamuller@gmail.com","Volkswagen");
        contact8 = new Contact("Michael Nyman","222444555","eldelpiano@gmail.com","Pianos Nyman");

        account1.setContacts(List.of(contact1, contact2));
        account2.setContacts(List.of(contact3));
        account3.setContacts(List.of(contact5, contact4));
        account4.setContacts(List.of(contact6));
        account5.setContacts(List.of(contact7));
        account6.setContacts(List.of(contact8));

        accountRepository.saveAll(List.of(account1, account2, account3, account4, account5, account6));
        contactRepository.saveAll(List.of(contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8));


        opportunity1 = new Opportunity(Product.BOX, 10, contact1, Status.OPEN, 1L);

        opportunity2 = new Opportunity(Product.FLATBED, 6, contact3, Status.CLOSED_WON, 1L);

        opportunity3 = new Opportunity(Product.HYBRID, 4, contact5, Status.CLOSED_WON, 1L);

        opportunity4 = new Opportunity(Product.FLATBED, 6, contact6, Status.CLOSED_LOST, 2L);

        opportunity5 = new Opportunity(Product.BOX, 10, contact7, Status.CLOSED_WON, 2L);

        opportunity6 = new Opportunity(Product.FLATBED, 6, contact8, Status.OPEN, 3L);


        opportunityRepository.saveAll(List.of(opportunity1,opportunity2,opportunity3,opportunity4,opportunity5,opportunity6));
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
        opportunityRepository.deleteAll();
        contactRepository.deleteAll();
    }

    @Test
    void showOpportunitiesBySalesRep_NoParams_JSON() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/opportunities_by_sales_rep"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("3"));
    }
//
//    @Test
//    void showClosedWonOpportunitiesBySalesRep_NoParams_JSON() throws Exception{
//        MvcResult mvcResult = mockMvc.perform(get("/closewon_opportunities_by_sales_rep"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//
//        assertTrue(mvcResult.getResponse().getContentAsString().contains("1"));
//        assertTrue(mvcResult.getResponse().getContentAsString().contains("2"));
//    }
//
//    @Test
//    void showClosedLostOpportunitiesBySalesRep_NoParams_JSON() throws Exception{
//        MvcResult mvcResult = mockMvc.perform(get("/closelost_opportunities_by_sales_rep"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//
//        assertTrue(mvcResult.getResponse().getContentAsString().contains("1"));
//
//    }
//
//    @Test
//    void showOpenOpportunitiesBySalesRep_NoParams_JSON() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(get("/open_opportunities_by_sales_rep"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//
//        assertTrue(mvcResult.getResponse().getContentAsString().contains("1"));
//    }
}