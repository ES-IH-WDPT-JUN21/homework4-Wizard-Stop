# CRM System (Microservice architecture)


Reconstruction of the CRM project where the command console input is replaced with an API interface, where you can manage your sales representatives, potential leads, opportunities, contacts and accounts.

It also allows you to generate reports with all the necessary statistics to efficiently manage your business.

## 🏙️ Microservice architecture
We have decided on a microservices design in which we have 3 services with independent databases, one for Leads, another for SalesRep and another microservice called "Customer-service" in which the Contact, 
Account and Opportunity classes are contained. This last microservice is in charge of generating the reports.

## 💻 Usage

Prior to being able to start the CRM System we need to manually setup our Databases using the included SQL Script
located in `account-service/src/main/resources/account.sql` , `customer-service/src/main/resources/sql` and
`lead-service/src/main/resources/sql` .

You can also find all http calls in the Postman collection located in `postman_collection.json`

## 🧑‍💻 About Us
The New-Wizard-Stop team is formed by:

[Almudena Álvarez Rodríguez - Sieiro](https://github.com/almudena-ars)

[María Lineros](https://github.com/mlineros)

[José A Bota](https://github.com/Jose-AB)

[María Campaña](https://github.com/Johari-lab)

[David de Ingunza](https://github.com/Deingun)



## 📌  Full Specifications


As a team, decide the best microservice architecture. Consider where edge services might be advantageous and necessary individual services. Make sure that you are designing together how the application will be broken into services before starting.

Then, rebuild the exact project from the ground up utilizing microservices architecture and creating API routes for every current CLI command.

___
