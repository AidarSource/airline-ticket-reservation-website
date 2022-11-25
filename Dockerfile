FROM openjdk:11
EXPOSE 8080
ADD /target/airline-ticket-reservation-website-1.0.jar
ENTRYPOINT ["java", "-jar", "airline-ticket-reservation-website-1.0.jar"]