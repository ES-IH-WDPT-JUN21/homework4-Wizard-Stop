package com.ironhack.customerservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.customerservice.controller.dto.ContactDTO;
import com.ironhack.customerservice.enums.Industry;
import com.ironhack.customerservice.model.Account;
import com.ironhack.customerservice.model.Contact;
import com.ironhack.customerservice.repository.AccountRepository;
import com.ironhack.customerservice.repository.ContactRepository;
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

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ContactControllerImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountRepository accountRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    private Account account;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        account = new Account(Industry.ECOMMERCE,10,"Madrid","Spain");
        accountRepository.save(account);
        contact1 = new Contact("Name Test 1", "6161616911", "test1@test.com", "company Test 1");
        contact2 = new Contact("Name Test 2", "161610616", "test2@test.com", "company Test 2");
        contact3 = new Contact("Name Test 3", "3161616166", "test3@test.com", "company Test 3");
        contact1.setAccount(account);
        contact2.setAccount(account);
        contact3.setAccount(account);

        contactRepository.saveAll(List.of(contact1,contact2,contact3));
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
        contactRepository.deleteAll();
    }

    @Test
    void findAll_NoParams_AllContacts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/contacts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Name Test 1"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Name Test 2"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Name Test 3"));
    }

    @Test
    void contact_ValidId_Contact() throws Exception {
        Long id = contact1.getId();
        MvcResult mvcResult = mockMvc.perform(get("/contacts/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Name Test 1"));
    }

    @Test
    void contact_InValidId_Contact() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/contacts/99999"))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void store_Valid_NewContact()throws Exception  {
        ContactDTO contactDTO = new ContactDTO("Name Test 4", "161601660", "test4@test.com", "company Test 4", account.getId());
        String body = objectMapper.writeValueAsString(contactDTO);
        MvcResult mvcResult = mockMvc.perform(post("/contacts")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
        )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Name Test 4"));
    }

    @Test
    void store_InValid_NewContact()throws Exception  {
        String body = "{\"phoneNumber\": \"6316106106\"," +
                "\"email\": \"test5@test.com\",\"companyName\": \"company Test 5\"," +
                "\"accountId\": \"1\" }";
        MvcResult mvcResult = mockMvc.perform(post("/contacts")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
        )
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void store_InValid_NewContactWrongEmail()throws Exception  {
        String body = "{\"name\": \"Name Test 5\",\"phoneNumber\": \"6316106106\"," +
                "\"email\": \"test5test.com\",\"companyName\": \"company Test 5\"," +
                "\"accountId\": \"1\" }";
        MvcResult mvcResult = mockMvc.perform(post("/contacts")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
        )
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void delete_ValidId_ContactDelete() throws Exception {
        Long id = contact1.getId();
        MvcResult mvcResult = mockMvc.perform(delete("/contacts/" + id))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void delete_InValidId_ContactDelete() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/contacts/99999"))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}