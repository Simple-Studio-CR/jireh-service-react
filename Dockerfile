FROM openjdk:11
VOLUME /tmp
ADD ./target/app-simplestudio-com-jireh-0.0.1-SNAPSHOT.jar jireh-service.jar
ENTRYPOINT ["java", "-jar", "jireh-service.jar"]
