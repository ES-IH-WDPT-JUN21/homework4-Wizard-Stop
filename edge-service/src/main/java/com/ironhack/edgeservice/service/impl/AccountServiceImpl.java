package com.ironhack.edgeservice.service.impl;
import com.ironhack.edgeservice.client.ContAccOppServiceClient;
import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.model.Contact;
import com.ironhack.edgeservice.model.Opportunity;
import com.ironhack.edgeservice.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

   @Autowired
    ContAccOppServiceClient contAccOppServiceClient;

    public Account findById(Long id)  {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }

    public void delete(Long id) {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
    }

    public void save(Account account)  {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
    }

    public Account obtainAccount(Contact contact, Opportunity opportunity){
//        Account account = null;
//        List<Account> allAccounts = accountRepository.findAll();
//        if (allAccounts.size() > 0) {
//            //Get number of employees
//            String command = "";
//            do {
//                PrintText.askIfCreateNewAccount();
//                command = Account.getIfCreateNewAccount();
//            } while (!command.trim().equalsIgnoreCase("Y") & !command.trim().equalsIgnoreCase("N"));
//
//            if (command.trim().equalsIgnoreCase("Y")) {
//                account = obtainAccountInput(contact, opportunity);
//            } else {
//                account = obtainExistingAccount(contact, opportunity);
//            }
//        } else{
//            account = obtainAccountInput(contact, opportunity);
//        }
//        contact.setAccount(account);
//        opportunity.setAccount(account);
//        return account;
        return null;

    }

    private Account obtainExistingAccount(Contact contact, Opportunity opportunity) {

//        Optional<Account> optionalAccount = null;
//        do {
//            PrintText.askIdOfExistingAccount();
//            Long idAccount = Account.getIdOfExistingAccount();
//            optionalAccount = accountRepository.findById(idAccount);
//            if (!optionalAccount.isPresent()){
//                PrintText.noIdFound("The ID " + idAccount + " does not match with any account");
//                PrintText.idDoesNotExist();
//                List<Account> allAccounts = accountRepository.findAll();
//                PrintText.recommendationShowAccounts(allAccounts);
//            }
//        } while (!optionalAccount.isPresent());
//
//
//        Account account = optionalAccount.get();
//        return account;
        return null;
    }

    public Account obtainAccountInput(Contact contact, Opportunity opportunity) {
//        //Get industry
//        Industry industry = null;
//        do {
//            PrintText.askIndustry();
//            industry = Industry.getIndustryFromScanner();
//        } while (industry == null);
//
//        //Get number of employees
//        int numberOfEmployees = 0;
//        do {
//            PrintText.askNumberOfEmployees();
//            numberOfEmployees = Account.getNumberOfEmployees();
//        } while (numberOfEmployees == 0);
//
//        Scanner scanner = new Scanner(System.in);
//
//        //Get city
//        //String city = null;
//        //PrintText.askCity();
//        //city = scanner.nextLine();
//
//        String city = "";
//        do{
//            PrintText.askCity();
//            String initialCity = Account.getCityFromUser();
//            if(initialCity.matches((Account.regexCityValidation()))) {
//                city = initialCity;
//            } else {
//                city = "";
//                PrintText.invalidName();
//            }
//        } while ("".equals(city));
//
//        //Get country
//        //String country = null;
//        //PrintText.askCountry();
//        //country = scanner.nextLine();
//
//        String country = "";
//        do{
//            PrintText.askCountry();
//            String initialCountry = Account.getCountryFromUser();
//            if(initialCountry.matches((Account.regexCountryValidation()))) {
//                country = initialCountry;
//            } else {
//                country = "";
//                PrintText.invalidName();
//            }
//        } while ("".equals(country));
//
//        Account account = new Account(industry, numberOfEmployees, city, country);
//        return account;
        return null;
    }

    public List<Account> getAll() {
        //LLAMADA A MICROSERVICIO ACCOUNT, CONTACT Y OPPORTUNITY
        return null;
    }
}
