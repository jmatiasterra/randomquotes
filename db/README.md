CREATE DATABASE randomquotes;
CREATE USER 'user1'@'localhost' IDENTIFIED BY 'user1';

GRANT ALL ON randomquotes.* TO 'user1'@'localhost';