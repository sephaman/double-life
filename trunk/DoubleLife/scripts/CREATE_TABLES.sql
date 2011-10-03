CREATE TABLE "user" (
    id        integer CONSTRAINT firstkey PRIMARY KEY,
    firstname       varchar(40) NOT NULL,
    lastname         varchar(40) NOT NULL,
    username   varchar(20) NOT NULL,
    password    varchar(20) NOT NULL
);

CREATE TABLE "bet" (
    id        integer PRIMARY KEY,
    userID       integer NOT NULL,
    dateReceived  date NOT NULL,
    stake   varchar(20) NOT NULL,
    pending    integer NOT NULL default(0),
    selectionID integer NOT NULL,
    betResult integer NOT NULL,
    moneyPaid float NOT NULL default(0.00)
);