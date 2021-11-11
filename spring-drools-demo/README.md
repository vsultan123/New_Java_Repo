Drools rules demo with spring application
===
Drools is a Business Rule Management System (BRMS) solution. It provides a rule engine which processes facts and produces output as a result of rules and facts processing. Centralization of business logic makes it possible to introduce changes fast.

In this sample SpringBoot application we are creating rules by making use of Drools Rules file (.drl) Rules can be updated dynamically without server restart.
A rule includes When-Then construct. The When section lists the condition to be checked, and Then section lists the action to be taken if the condition is met.
  
## Testing
Use rest client to interact with the API.

Sample POST request:

* http://localhost:8080/rules
* Sample request body
{
  "name":"mobile",
  "cardType":"ABC_Bank",
  "price":11000
}
* Sample response body
{
  "name": "mobile",
  "cardType": "ABC_Bank",
  "discount": 10,
  "price": 11000
}
* Change the rules and model as needed.