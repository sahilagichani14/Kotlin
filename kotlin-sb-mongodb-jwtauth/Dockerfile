#FROM openjdk:21
#LABEL authors="sahil"
##ADD target/kotlin-sb-mongodb-jwtauth-0.0.1-SNAPSHOT.jar app.jar
#ADD build/libs/kotlin-sb-mongodb-jwtauth.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]

# -------- STAGE 1: Build --------
FROM gradle:8.7-jdk17 AS build
WORKDIR /app
# Only copy the gradle wrapper and build files first for caching
COPY build.gradle.kts settings.gradle.kts gradlew gradle /app/
# Pre-download dependencies to leverage Docker layer caching
RUN ./gradlew build -x test || return 0
# Now copy the entire project
COPY . /app
# Build the JAR
RUN ./gradlew clean build -x test
# -------- STAGE 2: Run --------
FROM openjdk:17-slim
WORKDIR /app
# Copy JAR from previous stage
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]