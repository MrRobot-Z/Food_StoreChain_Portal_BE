# Food_StoreChain_Portal_Back-end


This is the Back-End Part of the project "Food_StoreChain_Portal" using Java EE with JAX-RS, JPA, EJB and JAAS.

You can check the Front-End Part <i><u>[Here](https://github.com/MrRobot-Z/Food_StoreChain_Portal_FE)</u></i>.

## Dependencies

+ JAVA EE 8

+ MySQL Database


This is a maven project so maven takes care of all other dependencies:
- Swarm to run server
- JAX-RS for Rest Services
- JPA for integration with a persistent DataBase (MySQL)
- EJB to handle fetching and database transactions
- JAAS for authentication of users 

## How to Run?

* run database scripts in <code>dp-scripts/</code> or we can simply create our own database with data (considering entity names)

* with maven installed run command <code>mvn clean install && java -jar target/Food_Portal_BE-swarm.jar</code>


## How to Use?

* When run the server can be found on  <code> localhost:8080/food-portal/ </code>

* We can then talk to the server using the browser (GET requests) or through Postman for other HTTP methods

* Alternatively we can talk to the server using the other part of this project the Front-end using AngularJS
 