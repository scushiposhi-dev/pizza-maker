# SpringBoot ms =>  pizza-maker

## Requirements

For building and running the application you need:

- JDK 17
- Maven >= 3.6 (alternatively use the provided maven wrapper)

## Building and Running the application locally

To run a Spring Boot application on your local machine you can choose from different ways.

One way is to execute the `main` method in the `com.example.pizzamaker.PizzaMakerApplication` class from your IDE.

Otherwise, you can use the requested maven version:
```shell
mvn clean install
mvn spring-boot:run
```
Easiest way with maven wrapper in Unix system:
```shell
./mvnw clean install
./mvnw spring-boot:run
```
Easiest way with maven wrapper in Windows:
```shell
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```
![img.png](img.png)