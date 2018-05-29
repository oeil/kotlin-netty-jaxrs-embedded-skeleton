# Kotlin WebApp Skeleton

Written in Kotlin using the following base libs
- Netty (embedded async web server)
- Jersey (jax-rs)
- Jackson (json)
- Logback (logging)

## Build Project
```
mvn clean package
```

## Run Application
```
java -jar target/kotlin-netty-jaxrs-embedded-skeleton-1.0.0-SNAPSHOT.jar
```
=> Browse http://localhost:8080/api/version

Specify Port and use Self-Signed Certificate
```
java -jar target/kotlin-netty-jaxrs-embedded-skeleton-1.0.0-SNAPSHOT.jar -Dport=9000 -Dssl=true
```
=> Browse https://localhost:9000/api/version
