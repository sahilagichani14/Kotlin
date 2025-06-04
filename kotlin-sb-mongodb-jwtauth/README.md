# Kotlin
- step 1: use spring initializer 
- step 2: add this to build.gradle.kts and run bootJar. => tasks.bootJar {
archiveFileName.set("kotlin-sb-mongodb-jwtauth.jar")
}
- run in terminal(Optional): C:\Users\sahil\Documents\Kotlin\kotlin-sb-mongodb-jwtauth> docker build -t sahil-sb-mongodb .
- run in terminal: C:\Users\sahil\Documents\Kotlin\kotlin-sb-mongodb-jwtauth> docker-compose up

# Swagger (same port as application server.port)
- Swagger UI: http://localhost:8081/swagger-ui.html
- OpenAPI JSON: http://localhost:8081/v3/api-docs

# MongoDB
- Connect with MongoDB Compass to Docker MongoDB using mongodb://localhost:27017/