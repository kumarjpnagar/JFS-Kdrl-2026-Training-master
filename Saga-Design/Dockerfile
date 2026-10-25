FROM java:8-jre
VOLUME /tmp
ADD target/component-eureka-0.0.1-SNAPSHOT.jar /app.jar

# All Spring Boot components expose 8080 as the container port
EXPOSE 8080
# Eureka may be started alternatively on port 8761
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
