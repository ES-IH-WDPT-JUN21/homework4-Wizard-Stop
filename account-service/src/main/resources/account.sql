DROP SCHEMA IF EXISTS `account`;
CREATE SCHEMA `account`;
USE `account`;

DROP SCHEMA IF EXISTS account_test;
CREATE SCHEMA account_test;
USE account_test;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	id BIGINT NOT NULL AUTO_INCREMENT,
    industry VARCHAR(255),
    employee_count INT,
    city VARCHAR(255),
    country VARCHAR(255),
    contact_id BIGINT,
    opportunity_id BIGINT,
    PRIMARY KEY(id)
);

INSERT INTO `account`(city, country, employee_count, industry, contact_id, opportunity_id) VALUES
('Madrid', 'España', 150, 'PRODUCE', 1, 1),
('Valencia', 'España', 300, 'MANUFACTURING', 2, 2),
('Pekin', 'China', 1800, 'ECOMMERCE', 3, 3),
('Nueva York', 'Estados Unidos', 1655, 'MEDICAL', 4, 4),
('Bilbao', 'España', 780, 'PRODUCE', 5, 5),
('Berlín', 'Alemania', 1500, 'OTHER', 6, 6);

SELECT * FROM `account`;
