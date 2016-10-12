# Triangle Rest Service

This is a [Spring Boot](https://spring.io/)  application which provides Rest Web Service API for getting triangle type. Project requires Java 8. 

To start app you need to clone the project and run it with Maven:

     mvn spring-boot:run
Rest service will be available on http://localhost:8080/triangle 
API accepts double parameters `a`, `b` and `c` as lengths of triangle and returns JSON with either triangle type or error description.
Sample request:

    http://localhost:8080/triangle?a=2&b=9&c=9
Response will have `Content-Type: application/json;charset=UTF-8` 
Sample response:

    {"message":"ISOSCELES"}
In case of invalid input API returns response with status 400, "Bad Request" and error JSON.
Sample error response: 
![Error view](https://raw.githubusercontent.com/anka976/triangle/master/src/main/resources/Screen%20Shot%202016-10-12%20at%2019.55.52.png "Error view")

To run tests execute command `mvn test`
