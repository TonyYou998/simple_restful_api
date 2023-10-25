FROM openjdk:latest as build
COPY target/simple_restful-1.1.0.jar simple_restful-1.1.0.jar
ENTRYPOINT ["java","-jar","/simple_restful-1.1.0.jar"]