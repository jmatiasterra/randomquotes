#DB Configuration

This rest api is using mysqldb to presist the authors and quotes data.

## Basic configuration 

create database randomquotes;
CREATE USER 'user1'@'%' IDENTIFIED BY 'user1';
GRANT ALL ON randomquotes.* TO 'user1'@'%';

CREATE TABLE author(
    id BIGINT NOT NULL auto_increment, 
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE quote(
    id BIGINT NOT NULL auto_increment, 
    text VARCHAR(250) NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    KEY author_id (author_id),
    CONSTRAINT quote_fk_1 FOREIGN KEY (author_id) REFERENCES author(id)
);

####TODO
I need to create a propper mysqldb dump of the data to be upload.