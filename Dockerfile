FROM adoptopenjdk/openjdk11
#ENV APP_HOME=/usr/app
#WORKDIR $APP_HOME
#COPY build/libs/*.jar app.jar
#ADD target/inventory-0.0.1-SNAPSHOT.jar inventory-0.0.1-SNAPSHOT.jar
ADD target/spring-boot-docker.jar spring-boot-docker.jar
EXPOSE 8008
ENTRYPOINT ["java", "-jar","inventory-0.0.1-SNAPSHOT.jar"]