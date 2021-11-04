
create schema crm;

use crm;

DROP TABLE IF EXISTS `lead`;
DROP TABLE IF EXISTS `opportunity`;
DROP TABLE IF EXISTS `contact`;

CREATE TABLE `lead`(
	id BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
    phone_number VARCHAR(30),
    email VARCHAR(255),
    company_name VARCHAR(255),
    sales_rep_id BIGINT,
	PRIMARY KEY(id)
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