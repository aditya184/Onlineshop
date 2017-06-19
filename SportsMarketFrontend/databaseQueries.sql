CREATE TABLE category (
	
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id) 

);

INSERT INTO category (name, description,image_url,is_active) VALUES ('Cricket', 'This is description for Cricket category!', 'Cricket.jpg', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Football', 'This is description for Football category!', 'football.jpg', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Tennis', 'This is description for Tennis category!', 'Tennis.jpg', true);

CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id),
);


INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Aditya', 'Joshi', 'ADMIN', true, 'admin', 'adityaj@gmail.com', '8888888888');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Bhavesh', 'Sonawane', 'SUPPLIER', true, '12345', 'Bhaveshs@gmail.com', '9999999999');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Vighanesh', 'Dait', 'SUPPLIER', true, '12345', 'ra@gmail.com', '7777777777');


CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);	


INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDCRBATSG123', 'SG English Willow Cricket Bat', 'SG', 'This is one of the Very good quality English willow bat', 2200, 4, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDCRGLSG123', 'SG Campus Batting Gloves', 'SG', 'Good quality Gloves', 350, 3, true, 1, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDFBADIDAS123', 'Adidas Football ', 'Adidas', 'This is one of the best Football', 560, 5, true, 2, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDFBADIDASGL123', ' Adidas Gloves', 'Adidas', 'This is one of the best Gloves', 1500, 3, true, 2, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDCRBATSS123', 'SS Master Kashmir Willow Cricket Bat', 'SS', 'This is one of the best Cricket bat', 1500, 4, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDTSHOE123', 'Tennis Shoe', 'Head', 'This is one of the best Tennis shoe', 3800, 4, true, 3, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDTRACQUET123', 'Nadal Tennis Racquet', 'Babolat', 'This is one of the best Tennis Racquet', 2500, 2, true, 3, 2 );
