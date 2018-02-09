# randomquotes

This is a small rest api project to manage quotes for authors.
The end of this project is to learn about rest api, spring framework, spring mvc, hibernate, spring security  

Actually this project has a basic spring security configuration


## description  
A quote will be related with one person only and a person could have 0 or more quotes.

## services

### /authors

This resource will allow to create, modify ,delete and query a particular author.

### /authors/{1}/quotes

This resource will allow  to create, modify ,delete quotes for a particular author. The author must be created   

### /quotes

I will be able to get all the quotes. No filter created, this method will return all the quotes


This is a work in progress 


## Configuration

### Mysql
First create the next tables on a mysql db

create database randomquotes;
CREATE USER 'user1'@'localhost' IDENTIFIED BY 'user1';
GRANT ALL ON randomquotes.* TO 'user1'@'localhost';

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


### Application basic Authentication

Currently the application has a basic authentication using user and password.
user: admin pass: admin123 role=ADMIN
user: user pass: user123 role=USER

Now this information is being save in memory but the idea will be create a particular table in the future.

POST http://host:port/randomquotes/oauth/token?grant_type=password&username=user123&password=user123

basic authentication
user valid_client
password client_secret


POST http://host:port/randomquotes/oauth/token?grant_type=refresh_token&refresh_token=

http://localhost:8080/SpringSecurityOAuth2Example/user/?access_token=3525d0e4-d881-49e7-9f91-bcfd18259109




