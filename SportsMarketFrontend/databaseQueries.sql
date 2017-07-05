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
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id),
);


INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Aditya', 'Joshi', 'ADMIN', true, '$2a$06$30JX37T/KNgKYGgz7W6Tm.XEW93WOFW9X0M7542LvbiwK0MxiR.Aq', 'aditya184@gmail.com', '8888888888');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Bhavesh', 'Sonawane', 'SUPPLIER', true, '$2a$06$9FzXgXnbF74m3k03kbltDuOMGBVv7DT1nkLyw6hKITdVHtQLi/kHO', 'bhaveshs@gmail.com', '9999999999');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Vighanesh', 'Dait', 'SUPPLIER', true, '$2a$06$WlpxixxeAgUVc3OqamerueNfjMq535WVPvpHPWHWtGHwWRx3TGwdu', 'vighaneshd@gmail.com', '7777777777');


INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Milind', 'Patel', 'USER', true, '$2a$10$yzPGHzq3Mz0Jv.TssQCGzu0348IQVJsz2bcdORAO4pqYvSI15XX5e', 'milindp@gmail.com', '2323232323');


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


CREATE TABLE address (
	id IDENTITY,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);


CREATE TABLE cart (
	id IDENTITY,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);

INSERT INTO address( user_id, address_line_one, address_line_two, city, state, country, postal_code, is_billing, is_shipping) 
VALUES (1, '128 Audumber Apartment, Cornation Road,', 'Near HDFC Bank ', 'Thane', 'Maharastra', 'India', '123456', true, false );
INSERT INTO cart (user_id, grand_total, cart_lines) VALUES (null, 0, 0);


