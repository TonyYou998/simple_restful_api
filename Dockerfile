FROM openjdk:latest as build
COPY target/simple_restful-0.0.1-SNAPSHOT.jar simple_restful-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/simple_restful-0.0.1-SNAPSHOT.jar"]