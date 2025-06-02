FROM openjdk:21
LABEL authors="sahil"
#ADD target/kotlin-sb-mongodb-jwtauth-0.0.1-SNAPSHOT.jar app.jar
ADD build/libs/kotlin-sb-mongodb-jwtauth.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]