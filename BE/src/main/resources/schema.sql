DROP TABLE REQUESTS IF EXISTS;
DROP TABLE REQUEST_TYPES IF EXISTS;

CREATE TABLE REQUEST_TYPES (
    ID integer auto_increment primary key,
    LABEL varchar(100) not null
);

CREATE TABLE REQUESTS (
    ID bigint auto_increment primary key,
    REQUEST_TYPE_ID integer not null,
    POLICY_NUMBER varchar(50) not null,
    NAME varchar(50) not null,
    SURNAME varchar(50) not null,
    MESSAGE varchar(2000) not null,
    foreign key (REQUEST_TYPE_ID) references REQUEST_TYPES(ID)
);

