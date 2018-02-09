# Container with the project

The idea will be build and run a container with the project https://github.com/jmatiasterra/randomquotes 


This container will have apache tomcat ready to run and project on the webapps folder (by default will be development branch)

Opcionally you could put on a particular host folder the configuration for a particular environment. The default one will be the only one that is in the project configuration folder.
if you start de container with -v this allow to you to edit this configuration files without enter to the container


## build

´´´
docker build -t randomquotes .

´´´

optionally --build-arg PROJECT_BRANCH=<branch_name> This only works for development for now


## run

´´´
docker run -d -p 127.0.0.1:8090:8080 --name randomquotes_inst_1 randomquotes  
´´´

optionally -v <path/to/config/folder>:/usr/local/tomcat/webapps/randomquotes/WEB-INF/classes/configuration/