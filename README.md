# cucumber-bdd-fw
This framework is a basic to write test in cucumber, following bdd approach

# Automated test example in Java with Cucumber and Selenium WebDriver #

This project is an example of UI automated functional test for Gmail account using Selenium and Cucumber.

Test scenarios are described in the feature file located here /Users/namitadubey/Downloads/workspace/cucumber-bdd-fw/Feature/LoginTest.feature


## Installation ##

You need to have [Java 8 JDK] installed along with [maven]

This test runs in Chrome browser. 

Change location of 'chromedriver' as per your file system in below file:

configs/Configuration.properties line 3

To install all dependencies, run 

```console
$ mvn clean install
```

## Running tests ##

```console
$ mvn test
```

After tests are run, reports are generated at : /target/cucumber-reports
