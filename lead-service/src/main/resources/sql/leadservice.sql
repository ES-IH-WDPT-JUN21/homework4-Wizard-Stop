CREATE SCHEMA leadservice;
USE leadservice;
GRANT ALL PRIVILEGES ON leadservice.*  TO "ironhack"@"%";

 
DROP TABLE IF EXISTS `lead`;

CREATE TABLE `lead`(
	id BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
    phone_number VARCHAR(30),
    email VARCHAR(255),
    company_name VARCHAR(255),
    sales_rep_id BIGINT,
	PRIMARY KEY(id)
);
