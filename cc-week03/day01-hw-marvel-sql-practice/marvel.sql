DROP TABLE attendances;
DROP TABLE movies;
DROP TABLE people;

CREATE TABLE movies (
	id SERIAL8 PRIMARY KEY,
	title VARCHAR(255),
	year INT2,
	show_time VARCHAR(255)
);

CREATE TABLE people (
	id SERIAL8 PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE attendances (
	id SERIAL8 PRIMARY KEY,
	person_id INT REFERENCES people(id) ON DELETE CASCADE,
	movie_id INT REFERENCES movies(id) ON DELETE CASCADE
);

INSERT INTO people (name) VALUES ('Arthur Andreev');
INSERT INTO people (name) VALUES ('Verity Ashforth');
INSERT INTO people (name) VALUES ('Kishan Bachoo');
INSERT INTO people (name) VALUES ('Miguel Moreno Baladrón');
INSERT INTO people (name) VALUES ('Oliver Berry');
INSERT INTO people (name) VALUES ('Paul Clatworthy');
INSERT INTO people (name) VALUES ('Alexander Fedenczuk');
INSERT INTO people (name) VALUES ('Jane Flucker');
INSERT INTO people (name) VALUES ('Graham Forrester');
INSERT INTO people (name) VALUES ('Natacha Galbano');
INSERT INTO people (name) VALUES ('Robert Gathergood');
INSERT INTO people (name) VALUES ('Rachel Johnson');
INSERT INTO people (name) VALUES ('Bert Overduin');
INSERT INTO people (name) VALUES ('Jussi Pardoe');
INSERT INTO people (name) VALUES ('Daniel Peet');
INSERT INTO people (name) VALUES ('Kte Preston');
INSERT INTO people (name) VALUES ('Amy Robertson');
INSERT INTO people (name) VALUES ('David Sanchez Rodriguez');
INSERT INTO people (name) VALUES ('Kashfa Tahir');
INSERT INTO people (name) VALUES ('Michaela Van Esveld');
INSERT INTO people (name) VALUES ('Jarrod Bennie');

INSERT INTO movies (title, year, show_time) VALUES ('Iron Man', 2008, '21:45');
INSERT INTO movies (title, year, show_time) VALUES ('The Incredible Hulk', 2008, '22:15');
INSERT INTO movies (title, year, show_time) VALUES ('Iron Man 2', 2010, '23:00');
INSERT INTO movies (title, year, show_time) VALUES ('Thor', 2011, '18:35');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: The First Avenger', 2011, '17:30');
INSERT INTO movies (title, year, show_time) VALUES ('Avengers Assemble', 2012, '20:25');
INSERT INTO movies (title, year, show_time) VALUES ('Iron Man 3', 2013, '22:55');
INSERT INTO movies (title, year, show_time) VALUES ('Thor: The Dark World', 2013, '12:10');
INSERT INTO movies (title, year, show_time) VALUES ('Batman Begins', 2005, '14:10');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: The Winter Soldier', 2014, '17:05');
INSERT INTO movies (title, year, show_time) VALUES ('Guardians of the Galaxy', 2014, '14:05');
INSERT INTO movies (title, year, show_time) VALUES ('Avengers: Age of Ultron', 2015, '22:30');
INSERT INTO movies (title, year, show_time) VALUES ('Ant-Man', 2015, '17:05');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: Civil War', 2016, '15:30');
INSERT INTO movies (title, year, show_time) VALUES ('Doctor Strange', 2016, '23:30');
INSERT INTO movies (title, year, show_time) VALUES ('Guardians of the Galaxy 2', 2017, '23:15');

INSERT INTO attendances (person_id, movie_id) VALUES (5, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (21, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (5, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (21, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (7, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (15, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (14, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (5, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (15, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (7, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (7, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (5, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (21, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (7, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (5, 7);

-- 1. Return ALL the data in the 'movies' table.
SELECT * FROM movies;

-- 2. Return ONLY the name column from the 'people' table
SELECT name FROM people;

-- 3. Oops! Someone at CodeClan spelled Kate's name wrong! Change it to reflect
-- the proper spelling (change 'Kte Preston' to 'Kate Preston').
UPDATE people SET name = 'Kate Preston' WHERE name = 'Kte Preston';

-- 4. Return ONLY your name from the 'people' table.
SELECT name FROM people WHERE name = 'Rachel Johnson';

-- 5. The cinema is showing 'Batman Begins', but Batman is DC, not Marvel!
-- Delete the entry from the 'movies' table.
DELETE FROM movies WHERE title = 'Batman Begins';

-- 6. Create a new entry in the 'people' table with the name of one of the
-- instructors.
INSERT INTO people (name) VALUES ('John Harper');

-- 7. Jarrod Bennie, has decided to hijack our movie evening, Remove him from
-- the table of people.
DELETE FROM people WHERE name = 'Jarrod Bennie';

-- 8. The cinema has just heard that they will be holding an exclusive midnight
-- showing of 'Guardians of the Galaxy 2'!! Create a new entry in the 'movies'
-- table to reflect this.
INSERT INTO movies (title, year, show_time)
VALUES ('Guardians of the Galaxy 2', 2017, '00:00');

-- 9. The cinema would also like to make the Guardian movies a back to back
-- feature. Update the 'Guardians of the Galaxy' show time from 18:55 to 21:30
UPDATE movies SET show_time = '21:30' WHERE title = 'Guardians of the Galaxy';
