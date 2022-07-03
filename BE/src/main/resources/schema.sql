DROP TABLE REQUEST_TYPES IF EXISTS;
CREATE TABLE REQUEST_TYPES (
    ID integer auto_increment primary key,
    LABEL varchar(100) not null
);