FROM openjdk:11
EXPOSE 8080
COPY /target/rest-docker.jar greet-api.jar
ENTRYPOINT ["java","-jar","/greet-api.jar"]