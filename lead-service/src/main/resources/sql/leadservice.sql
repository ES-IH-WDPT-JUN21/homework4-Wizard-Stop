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

INSERT INTO `lead`( `name`, company_name, email, phone_number, sales_rep_id) VALUES
('Javier','Airbus', 'javier@airbus.com', '677518326', 1),
('Jesus', 'Boeing','jesus@boeing.com', '697745727', 3),
('Rodrigo', 'Oxford','rodri@hotmail.com','666111444' ,1 ),
('Mariano','Pfizer', 'mariano@hotmail.com','666155155' ,2 ),
('Luis', 'BMW','luis@hotmail.com','656115454' ,4 ),
('Jose', 'Audi','jose@hotmail.com','655269454' ,2 );
