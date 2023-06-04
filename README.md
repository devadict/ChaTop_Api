### Installation ###

Firstly, you'll hava to go in the application.properties file and change the following credentials with yours:
spring.datasource.username=${spring.datasource.username}
spring.datasource.password=${spring.datasource.password}
app.secret=${app.secret}

### MY SQL ###

Start MYSQL GUI and run the following script : 

DROP DATABASE IF EXISTS rental;
CREATE DATABASE rental;

### Java Maven ###

Run `mvn spring-boot:run` in the root of the project

### Documentation ###

After running the API go the following URL to have access to the documentation:
http://localhost:3001/swagger-ui/#/