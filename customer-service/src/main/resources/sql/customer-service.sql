

create schema crm;

use crm;
DROP TABLE IF EXISTS `opportunity`;
DROP TABLE IF EXISTS `contact`;
DROP TABLE IF EXISTS `account`;


CREATE TABLE `account`(
	id BIGINT NOT NULL AUTO_INCREMENT,
    industry VARCHAR(255),
    employee_count INT,
    city VARCHAR(255),
    country VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE `contact`(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    phone_number VARCHAR(255),
	email VARCHAR(255),
    company_name VARCHAR(255),
    account_id BIGINT,
	PRIMARY KEY(id),
    FOREIGN KEY(account_id) REFERENCES account(id)
);

CREATE TABLE `opportunity`(
	id BIGINT NOT NULL AUTO_INCREMENT,
    product VARCHAR(255),
    quantity int,
    decision_maker_id BIGINT,
    status VARCHAR(255),
    sales_rep_id BIGINT,
    account_id BIGINT,
	PRIMARY KEY(id),
    FOREIGN KEY(decision_maker_id) REFERENCES contact(id),
    FOREIGN KEY(account_id) REFERENCES account(id)
);



INSERT INTO `account`(city, country, employee_count, industry) VALUES
('Madrid', 'España', 150, 'PRODUCE'),
('Valencia', 'España', 300, 'MANUFACTURING'),
('Pekin', 'China', 1800, 'ECOMMERCE'),
('Nueva York', 'Estados Unidos', 1655, 'MEDICAL'),
('Bilbao', 'España', 780, 'PRODUCE'),
('Berlín', 'Alemania', 1500, 'OTHER');

INSERT INTO contact( `name`, company_name, email, phone_number, account_id) VALUES
('Ester','Airbus', 'ester@airbus.com', '677555454', 1),
('Mayte', 'Boeing','mayte@gmail.com', '666555222', 3),
('Angel', 'Oxford','angel@hotmail.com','666125444' ,4 ),
('Andrés','Pfizer', 'andres@hotmail.com','666115444', 5 ),
('Lorena', 'BMW','lorena@hotmail.com','656525479' ,6 ),
('Jose', 'Audi','jose@hotmail.com','655269454' ,2 );

INSERT INTO opportunity( product, quantity, `status`, account_id, decision_maker_id, sales_rep_id) VALUES
('HYBRID', 5, 'OPEN', 1, 1 , 1),
('FLATBED', 30, 'OPEN', 2, 3 , 3),
('HYBRID', 50, 'CLOSED_WON', 3, 4 , 1),
('BOX', 40, 'CLOSED_LOST', 4, 5 , 2),
('BOX', 15, 'CLOSED_WON', 4, 6 , 4),
('FLATBED', 53, 'CLOSED_LOST', 6, 2, 2);