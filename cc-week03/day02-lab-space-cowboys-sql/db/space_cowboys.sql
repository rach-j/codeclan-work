DROP TABLE IF EXISTS space_cowboys;

CREATE TABLE space_cowboys(
id SERIAL4 PRIMARY KEY,
name VARCHAR(255),
species VARCHAR(255),
bounty_value INT8,
danger_level VARCHAR(255)
);
