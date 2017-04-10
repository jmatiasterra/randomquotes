# randomquotes

WIP


mysql

create database randomquotes;

CREATE TABLE author(
    id BIGINT NOT NULL auto_increment, 
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
