FROM openjdk:18
COPY target/ymir-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "ymir-0.0.1-SNAPSHOT.jar"]