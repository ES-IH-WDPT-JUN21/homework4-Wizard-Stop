DROP SCHEMA IF EXISTS homework;
CREATE SCHEMA homework;
USE homework;

DROP SCHEMA IF EXISTS crm_test;
CREATE SCHEMA crm_test;
USE crm_test;


DROP TABLE IF EXISTS sales_rep;
CREATE TABLE sales_rep(
	id BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
    PRIMARY KEY(id)
);



INSERT INTO sales_rep( `name`) VALUES
('Antonio'),
('Paco'),
('Alberto'),
('Alejandro');

SELECT * FROM sales_rep;

