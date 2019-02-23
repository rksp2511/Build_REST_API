# Amex REST API
## Hotel Booking Services

* Microservice can be started by issuing the following command
`java -jar target/hotel-booking-0.0.1-SNAPSHOT.jar`

* This microservice combines both hotels and booking services in the interest of time for the demo
* As part of this code base, I tried to demonstrate various artifacts of Domain Driven Design(DDD) such as
  Entities, Aggregates, Repositories, Services, VOs etc
* Below are the REST end points for the services
```
http http://localhost:8080/v1/hotels/
http http://localhost:8080/v1/hotels/NYC1
http http://localhost:8080/v1/hotels?name="Pen Station Hotel"
http POST http://localhost:8080/v1/hotels

http http://localhost:8080/v1/booking
http http://localhost:8080/v1/booking?name="My booking"
http http://localhost:8080/v1/booking/BOOK1
```
* swagger API docs can be accessed by double clicking on swaggerAPI.htm


# Thank you for checking the code!
