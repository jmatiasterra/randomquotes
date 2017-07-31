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

CREATE TABLE quote(
    id BIGINT NOT NULL auto_increment, 
    text VARCHAR(250) NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    KEY author_id (author_id),
    CONSTRAINT quote_fk_1 FOREIGN KEY (author_id) REFERENCES author(id)
);

CREATE TABLE tag(
    id BIGINT NOT NULL auto_increment, 
    text VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE quote_tag(
	text VARCHAR(250) NOT NULL,
	quote_id BIGINT NOT NULL,
	tag_id BIGINT NOT NULL,
    FOREIGN KEY (quote_id) REFERENCES quote(id) ON DELETE CASCADE ON UPDATE CASCADE, 
    FOREIGN KEY (tag_id) REFERENCES tag(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (quote_id, tag_id)
);

