CREATE TABLE Categories(id IDENTITY, name varchar(50), desc varchar(255), imageurl varchar(100), active boolean,
CONSTRAINT pk_category_id PRIMARY KEY (id)
);