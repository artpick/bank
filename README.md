![CI](https://github.com/artpick/bank/workflows/CI/badge.svg)

# Description

This is a simple SpringBoot Kotlin backend that simulate a banking account.
 
# Getting Started

Compile:
```bash
mvn clean install
```

# Sonar

Run:
```bash
docker pull sonarqube:8.5.1-community
docker run -p 9000:9000 sonarqube:8.5.1-community
mvn sonar:sonar
http://localhost:9000/
```
# Entity Diagram

![BANK Entities](doc/BANK.png)

# Reflection
* I had to set all entity properties to null and nullable because otherwise hibernate could not initialize them, maybe I should implement a dumb secondary or constructor with empty values.

# TODO
* Finish customer checking account controller
* Add business logic in services
* Use bean validation
* add withdraw money possibility with enum kind of financial transaction
* add currency attribute

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/#build-image)
* [Kotlin with Programiz](https://www.programiz.com/kotlin-programming)