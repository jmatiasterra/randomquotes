# Random Quotes Resource Server

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


## Application basic Authentication

####TODO 
I need to migrate the authorizacion server outside 

Currently the application has a basic authentication using user and password.
user: admin pass: admin123 role=ADMIN
user: user pass: user123 role=USER

Now this information is being save in memory but the idea will be create a particular table in the future.

POST http://host:port/rquotes_server/oauth/token?grant_type=password&username=user123&password=user123

basic authentication
user valid_client
password client_secret

### Resource Server 

POST http://host:port/rquotes_server/oauth/token?grant_type=refresh_token&refresh_token=

http://host:port/rquotes_server/user/?access_token=3525d0e4-d881-49e7-9f91-bcfd18259109


WIP



