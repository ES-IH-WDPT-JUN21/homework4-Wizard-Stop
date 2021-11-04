DROP SCHEMA IF EXISTS salesrep;
CREATE SCHEMA salesrep;
USE salesrep;


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

