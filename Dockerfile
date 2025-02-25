FROM gradle:jdk21 AS builder
COPY . /home/source/java
WORKDIR /home/source/java

# Default gradle user is `gradle`. We need to add permission on working directory for gradle to build.
USER root
RUN chown -R gradle /home/source/java
USER gradle
RUN gradle bootJar

FROM openjdk:21-jdk-slim
WORKDIR /home/source/java
COPY --from=builder /home/source/java/build/libs/inditex-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/inditex.jar"]