

# Equal Experts QA Task

### Purpose
This example project was developed by Ben I'Anson to complete the Equal Experts QA Task - The purpose of this is to display my approach to both Automation and Manual testing against the fictitious [http://hotel-test.equalexperts.io](http://hotel-test.equalexperts.io/) website.

### Key Features
* __BDD Enabled:__ The framework is built in [Cucumber](https://cucumber.io/).


* __Parallel Execution:__ Tests can be executed in [parallel](https://cucumber.io/blog/announcing-cucumber-jvm-4-0-0/).


* __Mavenised Execution:__ Framework is invoked via [Maven](https://maven.apache.org/) which allows for externalised test configuration via system properties parameters in addition to dependency management.


* __Dependency Injection:__ State is shared across Cucumber step definitions via [PicoContainer](http://picocontainer.com/injection.html).


* __Page Factory Design:__ The Page Object Model design pattern is extended to allow lazy initialisation of web elements via [Page Factory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory).



* __Embedded Bug Screenshots:__ A screenshot is taken of failing tests and provided in the Cucumber HTML report.



### Prerequisites
In order to utilise this project you need to have the following installed locally:


* ChromeDriver + GeckoDriver (both must be accessible from the system PATH)
* Chrome + Firefox
* Maven
* Java 8

### Usage
__Setup__

There are 2 different system properties to consider before triggering a test build - However, only `Dbrowser` is mandatory.

_Dbrowser_

There are a number of different browser options:


`-Dbrowser=chrome`

`-Dbrowser=firefox`

`-Dbrowser=headless-chrome`

`-Dbrowser=headless-firefox`


_Dparallel_

Tests can be executed in parallel by providing the following property:


`-Dparallel=both`

__Execution__

For a basic test run, navigate to `EE-Test-Project` directory and run:

`mvn clean test -Dbrowser=chrome`

For an accelerated test run, execute the below:

`mvn clean test -Dbrowser=headless-chrome -Dparallel=both`

Results of test runs can be located within the following report `target/cucumber/index.html`.


### Manual Test Summary
The summary of manual testing performed (Manual-Test-Summary.PDF) can be located in the root of the project folder.