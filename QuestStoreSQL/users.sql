DROP TABLE IF EXISTS users;

CREATE TABLE users (
    email character varying(255),
    password character varying(255),
    isAdmin character varying(255)
);

INSERT INTO users (email, password, isAdmin) VALUES ('codecooler@codecool.com', 'a', 'codecooler');
INSERT INTO users (email, password, isAdmin) VALUES ('a@b.com', 'aa', 'mentor');
INSERT INTO users (email, password, isAdmin) VALUES ('admin@codecool.com', 'aaa', 'admin');
INSERT INTO users (email, password, isAdmin) VALUES ('codecoolerNew@codecool.com', 'a', 'codecooler');

