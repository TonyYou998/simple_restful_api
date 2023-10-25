FROM openjdk:latest as build
COPY target/simple_restful-1.0.0.jar simple_restful-1.0.0.jar
ENTRYPOINT ["java","-jar","/simple_restful-1.0.0.jar"]