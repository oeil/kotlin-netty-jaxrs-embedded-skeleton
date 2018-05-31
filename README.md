# Kotlin WebApp Skeleton

Written in Kotlin using the following base libs
- Netty (embedded async web server)
- Jersey (jax-rs)
- Jackson (json)
- Logback (logging)
- maven (build)

## Build Project
```
mvn clean package
```

## Run Application
```
java -jar target/kotlin-netty-jaxrs-embedded-skeleton-1.0.0-SNAPSHOT.jar
```
=> Browse http://localhost:8080/api/version

#### Specify Port and use Self-Signed Certificate
```
java -Dport=9000 -Dssl=true -jar target/kotlin-netty-jaxrs-embedded-skeleton-1.0.0-SNAPSHOT.jar
```
=> Browse https://localhost:9000/api/version

## IntelliJ
IntelliJ already supports Kotlin out of the box. In order to import this project and make changes, all you need is to import the project as a Maven project ("Import Project"), choose the root directory where the pom.xml file is and select "Maven" as external Model. Next on IntelliJ wizard user all default maven settings plus check "Import Maven projects automatically" (you may also want to check "Automatically download Sources and Documentaiton" at the bottom) and then Next, Next, Finish.
