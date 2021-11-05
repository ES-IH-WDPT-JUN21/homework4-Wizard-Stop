
create schema salesrep;
use salesrep;

DROP TABLE IF EXISTS `sales_rep`;

CREATE TABLE `sales_rep`(
	id BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
	PRIMARY KEY(id)
);
INSERT INTO sales_rep( name) VALUES
('Juan'),
('Alfonso'),
('Marcos');
