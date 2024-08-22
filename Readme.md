# SpiceJet Site Automation project:

<p align="Left"><img src="Images/SpiceJet-Logo.jpg" alt="screenshot" width="400", height="200"></p>

This project is meant for testing the major functionalities of SpiceJet web site. I have used Data-Driven testing for testing Sign In functionality with Data provider. Also, this project covers the main features like One Way trip and Round trip scenarios as well.

## Motivation:
The reason behind creating this project is that automating this site is challenging and an interesting one, because of the Modern date picker and some web elements needs different approach for inspecting and handling web elements.

## Coding Style:
- I have used Java language with POM(Page Object Model) design pattern with Selenium framework in this project.

## IDE/Language:
- IDE : Eclipse
- Language : Java

## Technology/Frameworks used:
- TestNG framework - Used for various purposes like Data provider and the prioritization of tests and suites.
- Extent reports library - Used for the detailed reporting the test cases status with various information like screenshots.
- Maven project - For the ease of handling the dependencies in one place.
- Selenium Java library - Selenium provides support for the automation of web browsers. It provides extensions to emulate user interaction with browsers, a distribution server for scaling browser allocation, and the infrastructure for implementations of the W3C WebDriver specification.
- Apache POI library- For the reading and writing the data in Excel sheet.
- Maven Surefire plugin- For the building a Maven build in order to use it for Jenkins CI/CD implementation for invoking the build by local host or remotely.
- Jenkins tool - For triggering the build eventually executing the tasks locally or remotely.
- WebDriverManager library - Automated driver management and other helper features for Selenium WebDriver in Java.

## Test case Code Example:
- I have used constructor chaining here in order to access the methods of pages with single object creation.
- We are using try/catch to handle the exception that occurs in between the process of executing a test case.
- Finally, based on the validation if the test case is passed we report that test case as Pass/Fail in extent report.


## Test Scenarios covered:
- URL is broken or not
- Login scenarios(Positive and Negative)
- SignUp scenarios(Positive and Negative)
- One Way trip scenario
- Round trip scenario 
- CheckIn Scenario
- Manage Bookings Scenario
- Flight Status Scenario

## People worked on this project
```Supriya```

