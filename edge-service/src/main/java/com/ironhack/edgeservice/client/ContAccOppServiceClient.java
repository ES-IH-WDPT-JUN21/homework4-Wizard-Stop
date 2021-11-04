package com.ironhack.edgeservice.client;


import com.ironhack.edgeservice.controller.dto.AccountDTO;
import com.ironhack.edgeservice.controller.dto.ContactDTO;
import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.model.Contact;
import com.ironhack.edgeservice.model.Opportunity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@FeignClient("customer-service")
public interface ContAccOppServiceClient {

    @GetMapping("/contacts")
    public List<Contact> findAll();

    @GetMapping("/contacts/{id}")
    public Contact contact(@PathVariable(name = "id") Long id);

    @PostMapping("/contacts")
    public Contact store(@RequestBody ContactDTO contactDTO);

    @DeleteMapping("/contacts/{id}")
    public void delete(@PathVariable(name = "id") Long id);

    @GetMapping("/accounts")
    public List<Account> getAllAccounts();

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable Long id);

    @PostMapping("/accounts")
    public Account store(@RequestBody @Valid AccountDTO account);

    @DeleteMapping("/accounts/{id}")
    public void deleteById(@PathVariable Long id);

    @GetMapping("/opportunities")
    public List<Opportunity> getAll();

    @GetMapping("/opportunities/{id}")
    public Opportunity getById(@PathVariable(name = "id") Long opportunityId);

    @PostMapping("/opportunities")
    public Opportunity add(@Valid @RequestBody OpportunityDTO opportunity);

    @GetMapping("/opportunities/closelost/{id}")
    public String closeLost(@PathVariable(name = "id") Long id);

    @GetMapping("/opportunities/closewon/{id}")
    public String closeWon(@PathVariable(name = "id") Long id);

    @GetMapping("/opportunities_by_sales_rep")
    public List<Object[]> showOpportunitiesBySalesRep();

    @GetMapping("/closewon_opportunities_by_sales_rep")
    public List<Object[]> showClosedWonOpportunitiesBySalesRep();

    @GetMapping("/closelost_opportunities_by_sales_rep")
    public List<Object[]> showClosedLostOpportunitiesBySalesRep();

    @GetMapping("/open_opportunities_by_sales_rep")
    public List<Object[]> showOpenOpportunitiesBySalesRep();

    @GetMapping("/opportunities_by_product")
    public List<Object[]> opportunitiesByProduct();

    @GetMapping("/open_opportunities_by_product")
    public List<Object[]> openOpportunitiesByProduct();

    @GetMapping("/closewon_opportunities_by_product")
    public List<Object[]> wonOpportunitiesByProduct();

    @GetMapping("/closelost_opportunities_by_product")
    public List<Object[]> lostOpportunitiesByProduct();

    @GetMapping("/opportunities_by_country")
    public List<Object[]> opportunitiesByCountry();

    @GetMapping("/open_opportunities_by_country")
    public List<Object[]> openOpportunitiesByCountry();

    @GetMapping("/closewon_opportunities_by_country")
    public List<Object[]> wonOpportunitiesByCountry();

    @GetMapping("/closelost_opportunities_by_country")
    public List<Object[]> lostOpportunitiesByCountry();

    @GetMapping("/opportunities_by_city")
    public List<Object[]> opportunitiesByCity();

    @GetMapping("/open_opportunities_by_city")
    public List<Object[]> openOpportunitiesByCity();

    @GetMapping("/closewon_opportunities_by_city")
    public List<Object[]> wonOpportunitiesByCity();

    @GetMapping("/closelost_opportunities_by_city")
    public List<Object[]> lostOpportunitiesByCity();

    @GetMapping("/opportunities_by_industry")
    public List<Object[]> opportunitiesByIndustry();

    @GetMapping("/open_opportunities_by_industry")
    public List<Object[]> openOpportunitiesByIndustry();

    @GetMapping("/closewon_opportunities_by_industry")
    public List<Object[]> wonOpportunitiesByIndustry();

    @GetMapping("/closelost_opportunities_by_industry")
    public List<Object[]> lostOpportunitiesByIndustry();
}
