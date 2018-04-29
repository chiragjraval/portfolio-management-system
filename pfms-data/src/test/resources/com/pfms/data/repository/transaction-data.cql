CREATE TABLE transaction (
    id uuid PRIMARY KEY,
    type text,
    quantity int,
    price double,
	clientId text,
	executionDate timestamp,
	settlementDate timestamp
);

TRUNCATE TABLE transaction;

INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'BUY', 100, 15.00, 'CHIRAG', '2016-01-10', '2016-01-12');
INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'SELL', 1110, 14.00, 'CHIRAG', '2016-01-10', '2016-01-12');
INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'BUY', 200, 30.00, 'CHIRAG', '2016-01-10', '2016-01-12');
INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'BUY', 110, 1000.00, 'NIKUNJ', '2016-01-10', '2016-01-12');
INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'SELL', 150, 1500.00, 'NIKUNJ', '2016-01-10', '2016-01-12');
INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'SELL', 10, 200.00, 'NIKUNJ', '2016-01-10', '2016-01-12');
INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'BUY', 100, 55.00, 'NIKUNJ', '2016-01-10', '2016-01-12');
INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'BUY', 990, 35.00, 'DIVYA', '2016-01-10', '2016-01-12');
INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'SELL', 5000, 25.00, 'DIVYA', '2016-01-10', '2016-01-12');
INSERT INTO transaction (id, type, quantity, price, clientId, executionDate, settlementDate) VALUES (uuid(), 'BUY', 5, 4000.00, 'DIVYA', '2016-01-10', '2016-01-12');
