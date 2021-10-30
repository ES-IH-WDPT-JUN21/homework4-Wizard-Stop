package com.ironhack.customerservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.customerservice.controller.dto.AccountDTO;
import com.ironhack.customerservice.enums.Industry;
import com.ironhack.customerservice.model.Account;
import com.ironhack.customerservice.repository.AccountRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccountControllerImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AccountRepository accountRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Account account1;
    private Account account2;
    private Account account3;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        account1 = new Account(Industry.ECOMMERCE, 22, "Barcelona", "España", null, null);
        account2 = new Account(Industry.MANUFACTURING, 24, "Madrid", "España", null, null);
        account3 = new Account(Industry.MEDICAL, 18, "Valencia", "España", null, null);

        accountRepository.saveAll(List.of(account1, account2, account3));
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
    }

    @Test
    void getAll_validAccounts_allAccounts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Barcelona"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Madrid"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Valencia"));
    }

    @Test
    void getById_validId_accountById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/accounts/" + account1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Barcelona"));
    }

    @Test
    void store_validAccount_accountCreated() throws Exception {
        AccountDTO account4 = new AccountDTO(4L, Industry.MEDICAL, 21, "Vigo", "España", 4L, 4L);
        String body = objectMapper.writeValueAsString(account4);
        MvcResult mvcResult = mockMvc.perform(post("/accounts")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Vigo"));
    }

    @Test
    void deleteById_validId_accountDeleted() throws Exception {
        mockMvc.perform(delete("/contacts/" + account3.getId()))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}