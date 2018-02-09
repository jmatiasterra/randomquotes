FROM openjdk:8-jdk-alpine

ARG PROJECT_BRANCH
ENV PROJECT_BRANCH {PROJECT_BRANCH:-development}
ENV PROJECT_DEPLOY_FOLDER /usr/local/tomcat/webapps

RUN app add git maven

RUN mkdir /etc/project

RUN mkdir /etc/scripts

COPY ./scripts/start.sh /etc/scripts

RUN cd /etc/project

RUN git clone -b development https://github.com/jmatiasterra/randomquotes.git

Run cd randomquotes

Run mvn clean package

WORKDIR /etc/scripts

EXPOSE 8080
CMD ["./start.sh"]
#CMD ["catalina.sh", "run"]