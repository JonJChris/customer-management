FROM openjdk:17
COPY target/CustomerManagement-1.0.jar CustomerManagement-1.0.jar
ENTRYPOINT ["java", "-jar", "/CustomerManagement-1.0.jar"]