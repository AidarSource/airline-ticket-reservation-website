FROM openjdk:11
EXPOSE 8080
ADD /target/airline-website-1.0.jar airline-website-1.0.jar
ENTRYPOINT ["java","-jar","airline-website-1.0.jar"]