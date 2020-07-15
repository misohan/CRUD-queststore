DROP TABLE IF EXISTS artifacts CASCADE;
DROP TABLE IF EXISTS codecoolers CASCADE;
DROP TABLE IF EXISTS mentors CASCADE;
DROP TABLE IF EXISTS quests CASCADE;

CREATE TABLE users(
    ID serial PRIMARY KEY,
	firstname varchar(25) NOT NULL,
	lastname varchar(25) NOT NULL,
	email varchar(55) NOT NULL,
	password varchar (55) NOT NULL,
	isadmin varchar(1) NOT NULL
);


CREATE TABLE codecoolers(
    ID serial PRIMARY KEY,
	firstname varchar(25) NOT NULL,
	lastname varchar(25) NOT NULL,
	age int NOT NULL
);

CREATE TABLE mentors(
    ID serial PRIMARY KEY,
	firstname varchar(25) NOT NULL,
	lastname varchar(25) NOT NULL,
	age int NOT NULL
);

CREATE TABLE artifacts(
    ID serial PRIMARY KEY,
	title varchar(25) NOT NULL,
	description varchar(255) NOT NULL,
	credit float NOT NULL
);

CREATE TABLE quests(
    ID serial PRIMARY KEY,
	title varchar(25) NOT NULL,
	description varchar(255) NOT NULL,
	credit float NOT NULL
);
