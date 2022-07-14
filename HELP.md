# gRPC communication with Spring Boot

# Getting Started

### Compilation and start-up

```
mvn clean install
cd rental-grpc-service
mvn spring-boot:run
```

### Calling gRPC methods

```
grpcurl --plaintext localhost:9090 list
grpcurl --plaintext localhost:9090 list pl.ztrzaska.grpc.ReservationService

grpcurl --plaintext -d "{\"period\": \"month\", \"cost\": \"500\", \"renterId\": \"1\", \"objectForRentId\": \"1\"}" localhost:9090 pl.ztrzaska.grpc.ReservationService/reserve
grpcurl --plaintext -d "{\"id\": \"1\", \"cost\": \"400\", \"period\": \"month\"}" localhost:9090 pl.ztrzaska.grpc.ReservationService/modify
grpcurl --plaintext -d "{\"name\": \"RENTER1\"}" localhost:9090 pl.ztrzaska.grpc.ReservationService/findByByRenter
grpcurl --plaintext -d "{\"name\": \"NAME1\"}" localhost:9090 pl.ztrzaska.grpc.ReservationService/findByObjectForRentName
```


### Reference Documentation
For further reference, please consider the following sections:

* [Grpc framework](https://grpc.io/)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Spring boot gRPC](https://yidongnan.github.io/grpc-spring-boot-starter/en/server/getting-started.html)
* [Grpc stubs with Spring Boot](https://yidongnan.github.io/grpc-spring-boot-starter/en/client/getting-started.html)

