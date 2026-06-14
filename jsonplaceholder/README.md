# RestAssured API Automation Framework

API test Automation is done withwith JSONPlaceholder as the demo endpoint.
URL- https://jsonplaceholder.typicode.com
A API test automation framework using **RestAssured** (Java), **TestNG**, and **Maven** for testing REST API. 

##Test Scenarios
Test ID	Description	Expected Result

TC001	Create a new post successfully	Status 201 + correct response fields

TC002	Get non-existent post	Status 404 Not Found

TC003	Access invalid endpoint	Status 404 Not Found

TC004	Retrieve existing post	Status 200 + valid fields

##  Features

-  Successful API request validation - Status code & response fields
-  Failure scenario handling - 404, bad requests, invalid endpoints
-  JSON Schema validation - Response structure validation


##Running Tests
From Eclipse IDE

Run single test class	Right-click PostApiTests.java → Run As → TestNG Test

Run via testng.xml	Right-click testng.xml → Run As → TestNG Suite

Run as Maven	Right-click project → Run As → Maven test

##  Prerequisites

 Software  Version

 Java  
 Maven Build Automation 
 Eclipse IDE 


## Technology used:

 RestAssured  API testing library 
 
 TestNG Test framework 

