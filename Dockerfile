FROM openjdk:17-jdk-alpine
COPY build/libs/*.jar reservation-service.jar
ENTRYPOINT ["java","-jar","/reservation-service.jar"]