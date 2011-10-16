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

CREATE TABLE "userstock" (
    id        integer PRIMARY KEY,
    userID       integer NOT NULL,
    quantity         integer NOT NULL,
    basePrice   float NOT NULL,
    stockCode    varchar(10) NOT NULL,
    buyDate date NOT NULL,
    marketValue float NOT NULL,
);

CREATE TABLE "stockorder" (
    id        integer PRIMARY KEY,
    userID       integer NOT NULL,
    quantity         integer NOT NULL,
    price   float NOT NULL,
    stockCode    varchar(10) NOT NULL,
    dateReceived date NOT NULL
);

CREATE TABLE bet_participant
(
   id integer PRIMARY KEY,
   name    varchar(50) NOT NULL,
   updateDateTime date NOT NULL,
   primaryBetEventTypeId integer
); 

CREATE TABLE bet_event_type
(
	id integer PRIMARY KEY,
   name    varchar(50) NOT NULL,
   updateDateTime date NOT NULL
);

CREATE TABLE user_betting_account
(
	id integer PRIMARY KEY,
   userid    integer NOT NULL,
   amount float NOT NULL,
   updateDateTime date NOT NULL
);

CREATE TABLE bet_event
(
	id integer PRIMARY KEY,
   betEventTypeId    integer NOT NULL,
   dateTime date NOT NULL,
   outcomePending integer NOT NULL,
   selectionWinnerId integer
);

CREATE TABLE participant_betevent
(
id integer PRIMARY KEY,
participantId integer NOT NULL,
betEventId integer NOT NULL
);
