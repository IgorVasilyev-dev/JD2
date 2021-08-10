FROM tomcat:8.5.69-jdk11-adoptopenjdk-hotspot

LABEL maintainer="v-i-v-igor@yandex.ru"

ADD target/Polyclinic-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]