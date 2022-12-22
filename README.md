# GraphQL POS
## Requirements
1. Java 8
2. MySQL Server 8.0
3. Gradle 6.8.3

## Instructions to Execute

1. Clone Project
2. Import MySQL database dump file - src/main/resources/anymind-pos.sql (Easier via MySQL Workbench import wizard). 
* note: MySQL connection is localhost:3306 with user=root and password=root
4. From project root folder execute:
* gradlew clean build
* gradlew bootRun
5. Go to localhost:8081/graphiql in browser or localhost:8081/graphql in POSTMAN

### Sample request to add PAYMENT
```json
mutation {
  createPayment(input: {
    customerId: 123,
    paymentMethod: "CASH_ON_DELIVERY",
    price: 123.50,
    priceModifier: 1,
    dateTime: "2022-01-02T05:40:00Z",
    additionalItem: {
      courier: "YAMATO"
    }
    
  }) {
    finalPrice
    points
  }
}
```
### Sample request to retrieve sales
```json
query {
	sales(input: {
    startDateTime: "2022-01-01T05:00:00Z", 
    endDateTime: "2022-01-10T23:59:59Z"
  }) {
	  dateTime
	  sales
	  points
	}
}
```
