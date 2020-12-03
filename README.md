# garage-simulator
Garage Simulaor



### Guides
The following guides illustrate how to use some features concretely:
Parking simulator application 


#### Download App

```
https://github.com/samionder/garage-simulator.git
```

### Getting started

1. Go to project folder and install all the setups related to maven(pom.xml):

  ```
  $ ./mvnw clean install
  ```

2. in the project folder go to target folder and run app.

  ```
  $ java -jar garage-simulator-0.0.1-SNAPSHOT.jar
  ```
  
### Testing
Postman collection file provided, use postman collection file for testing.


### API Usage
1. for getting garage current status use

  ```
  GET: /api/garage/status
  ```
2. for parking new vehicles use

  ```
  POST: /api/garage/park
  ```
 
3. for leaving vehicles use

  ```
  POST: /api/garage/leave
  ```
  
  
###Sample Input 1

	park 34-SO-1988 Black Car
	park 34-BO-1987 Red Truck
	park 34-VO-2018 Blue Jeep
	park 34-HBO-2020 Black Truck
	leave 3
	park 34-LO-2000 White Car
	status

###Sample Output 1
	Allocated 1 slot.
	Allocated 4 slots.
	Allocated 2 slots.
	Garage is full.
	Allocated 1 slot.
	Status:
	34-SO-1998 Black [1]
	34-BO-1987 Red [3,4,5,6]
	34-LO-2000 Black [8]