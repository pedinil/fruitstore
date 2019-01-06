# Project Title

FruiteStore project Test project base on spring Boot


## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.cybercom.FruitstoreApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

## Running the tests
The class `com.cybercom.RestFruitsControllerTest` is Responsible  for unit test 


## Authors
* **Pedram Ezzati** - *Initial work* - [pedinil](https://github.com/pedinil)

## Description
this project is used connect to broker by mqtt  and  subscribe  and once the message arrived save it to DB
project will provide rest API to user to save update and get the list of fruit
 
there are 3 layer in this project
1. controller layer : which handle all rest request 
2. service layer : which handle all business logic or application logic
3. Data access layer : to handle connecting to DB by spring.data 



