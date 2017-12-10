
CREATE TABLE Categories(
id IDENTITY, 
name varchar(50), 
desc varchar(255), 
imageurl varchar(100), 
active boolean,
CONSTRAINT pk_category_id PRIMARY KEY (id)
);


CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

CREATE TABLE products (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES categories (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);


INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Batman', '' ,'ADMIN', true, 'iamrich', 'bats@gmail.com', '1111111111');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Superman', '' , 'SUPPLIER', true, 'loislane', 'hope@gmail.com', '8888888888');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Wonder Woman', '', 'SUPPLIER', true, 'diana', 'diana@gmail.com', '7777777777');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Aqua Man', '', 'USER', true, 'fishtalker', 'aquaman@gmail.com', '1234567890');

INSERT INTO products (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('gpu1', 'Asus Strix GTX 1080 ti ', 'Asus', 'Base clock 1632 MHz Boost Clock (OC Mode) featuring 11GB GDDR5X 352-bit memory, 3584 CUDA cores, and 11GB Frame Buffer', 65000, 20, true, 1, 2, 0, 0 );
INSERT INTO products (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('cpu1', 'Intel Core i7 8700k', 'Intel', 'Intel 8th Gen Core i7-8700K Processor 6 Cores/12 Threads',45000, 25, true, 2, 3, 0, 0 );
INSERT INTO products (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('cpu2', 'AMD Ryzen Threadripper 1950X', 'AMD', 'AMD Ryzen Threadripper 1950X (16-core/32-thread) Desktop Processor',50000, 20, true, 2, 2, 0, 0 );
INSERT INTO products (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('mem1', 'Corsair Vengeance Pro 16GB','Corsair', '2 x 8 GB kit DDR4 2400mhz', 10000, 100, true, 5, 2, 0, 0 );
INSERT INTO products (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('ssd1', 'Samsung 850 EVO 500GB','Samsung', 'Samsung 850 EVO 500GB with R/W 540MB/s and 520MB/s respectively ', 25000, 10, true, 2, 3, 0, 0 );
INSERT INTO products (code, name, brand, description, unit_price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('logig810', 'Logitech G810 RGB Gaming Keyboard','Logitech','Logitech G810 Orion Spectrum RGB Mechanical Gaming Keyboard w/ Ultra-Responsive Romer-G Mechanical Key Switches', 10000, 15, true, 9, 3, 0, 0 );

alter table product rename to products;