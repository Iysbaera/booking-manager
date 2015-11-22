# Booking Manager [![Build Status](https://travis-ci.org/hradecek/booking-manager.svg?branch=master)](https://travis-ci.org/hradecek/booking-manager)

Booking manager is student's project of the [_Enterprise Java_ course](https://is.muni.cz/predmet/fi/podzim2011/PA165?lang=en)  teaching at [Faculty of Informatics](https://www.fi.muni.cz/index.xhtml.en) [Masaryk University](https://www.muni.cz/?lang=en).

For more information about project see official [Wiki pages](https://github.com/hradecek/booking-manager/wiki).

## Used technologies:
* __Application framework__ - [Spring](https://spring.io/)
* __ORM framework__ - [Hibernate](http://hibernate.org/)
* __Testing framework__ - [TestNG](http://testng.org/doc/index.html)
* __Mocking framework__ - [Mockito](http://mockito.org/)
* __Build tool__ - [Maven](https://maven.apache.org/)

## Modules
Whole project is divided to several maven projects representing specific layers:
* __booking-manager-service__ - Represents service layer and contains implementations of facades,
* __booking-manager-api__ - Represents API layer, which contains Data Transfer Objects and defines interfaces for facades,
* __booking-manager-persistence__ - Represents persistent layer, which provides DB operations via Data Access Objects.

## Testing
For unit testing there are no special set ups. Project uses TestNG framework with Mockito support for objects mocking.
Configuration of database for testing can be found under *src/test/resources/persistence.xml*. By default tests use in memory derby database.

To run test use maven command:
```
$ mvn test
```

## Installation
For installation use maven command:
```
mvn clean install
```

## Collaborators
* [Juraj Bielik](https://github.com/Neytus)
* [Jana Čecháčková](https://github.com/xcechack)
* [Michal Hornák](https://github.com/expresado)
* [Ivo Hrádek](https://github.com/hradecek)
