CREATE TABLE "user" (
    id        integer CONSTRAINT firstkey PRIMARY KEY,
    firstname       varchar(40) NOT NULL,
    lastname         varchar(40) NOT NULL,
    username   varchar(20) NOT NULL,
    password    varchar(20) NOT NULL
);