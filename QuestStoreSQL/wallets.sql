DROP TABLE IF EXISTS wallets;

CREATE TABLE wallets (
    email character varying(255),
    accountBalance int

);

INSERT INTO wallets (email, accountBalance) VALUES ('codecooler@codecool.com', 15000);
INSERT INTO wallets (email, accountBalance) VALUES ('codecoolerNew@codecool.com', 27000);

