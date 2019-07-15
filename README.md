# QA Automation Framework

This is an example of automation for the web o Zattoo, this is made with the patern design Page Object, suggested by Selenium, use the framework: Selenium, Cucumber, Log4J and Maven. The logic of cucumber mention this order of the execution:

Features Files -> Step Definitions -> Pages 

The principal folders are:

The features files, they are the content of the feature and they are in cucumber format (given, then, and,  when) the location of this, is this path:
zattoo_example/src/test/resources/zattoo_example/TestCaseWithWeb.feature

The Steps definitions Files, they are the definitions of the steps defined in the feature files. Te location of this files are this:
zattoo_example/src/test/java/zattoo_example/Stepdefs.java

The Pages, they content inside the locators of the pages and the methods to execute all the actions per page. The location of this classes is this: 
zattoo_example/src/test/java/zattoo/example/pages


## Used tools
 - Java
 - Maven
 - Cucumber
 - Selenium Webdriver

## Preconditions
- install Java 8
- install Maven
- install Git

## How to run tests localy

#To download the project, in the terminal (Mac or Windows) execute this git command:
git clone 

#in the directory of project make:
mvn eclipse:eclipse
mvn clean compile

#To execute the example:
mvn test

