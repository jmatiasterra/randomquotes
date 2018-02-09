FROM openjdk:8-jdk-alpine

ARG PROJECT_BRANCH
ENV PROJECT_BRANCH ${PROJECT_BRANCH:-development}
ENV PROJECT_NAME randomquotes

RUN apk --update add git maven

ADD http://apache.dattatec.com/tomcat/tomcat-9/v9.0.4/bin/apache-tomcat-9.0.4.tar.gz /opt/
RUN tar -xzf /opt/apache-tomcat-9.0.4.tar.gz -C /opt/
RUN rm /opt/apache-tomcat-9.0.4.tar.gz
ENV PROJECT_DEPLOY_FOLDER /opt/apache-tomcat-9.0.4/webapps

RUN mkdir /etc/project
RUN mkdir /etc/scripts
COPY ./scripts/start.sh /etc/scripts/temp.sh
RUN cat /etc/scripts/temp.sh | tr -d '\r' > /etc/scripts/start.sh
RUN rm /etc/scripts/temp.sh
RUN chmod +x /etc/scripts/start.sh

WORKDIR /etc/project

RUN git clone -b ${PROJECT_BRANCH} https://github.com/jmatiasterra/${PROJECT_NAME}.git

WORKDIR /etc/project/$PROJECT_NAME

RUN mvn clean package

RUN mkdir ${PROJECT_DEPLOY_FOLDER}/${PROJECT_NAME}

RUN cp ./target/${PROJECT_NAME}.war ${PROJECT_DEPLOY_FOLDER}/${PROJECT_NAME}

WORKDIR /etc/scripts

EXPOSE 8080
CMD ["./start.sh"]
#CMD ["catalina.sh", "run"]