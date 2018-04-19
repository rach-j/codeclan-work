DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS screenings;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS films;


CREATE TABLE customers (
  id SERIAL4 PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  funds DECIMAL(10,2) NOT NULL
);

CREATE TABLE films (
  id SERIAL4 PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  price DECIMAL(10,2) NOT NULL
);

CREATE TABLE screenings (
  id SERIAL4 PRIMARY KEY,
  show_time VARCHAR(255) NOT NULL,
  film_id INT4 REFERENCES films(id)
);

CREATE TABLE tickets (
id SERIAL4 PRIMARY KEY,
customer_id INT4 REFERENCES customers(id),
screening_id INT4 REFERENCES screenings(id)
);
