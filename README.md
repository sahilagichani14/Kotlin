# Kotlin
- step 1: use spring initializer 
- step 2: add this to build.gradle.kts and run bootJar. => tasks.bootJar {
archiveFileName.set("kotlin-sb-mongodb-jwtauth.jar")
}
- run in terminal: C:\Users\sahil\Documents\Kotlin\kotlin-sb-mongodb-jwtauth> docker build -t sahil-sb-mongodb .
- run in terminal: C:\Users\sahil\Documents\Kotlin\kotlin-sb-mongodb-jwtauth> docker-compose up