# Struts2 JQuery Integration tests
## Intentions of the module
This module was created with the intention of having an automatic way of checking if changes made would break or change existing functionality.
## Used setup
#### Selenium WebDriver
The tests in this module use Selenium Webdriver in order to do integration tests.
There are currently 2 Webdriver implementations that are configured to run
- HtmlUnitDriver
- PhantomJSDriver

Not all tests are possible to run with each of the drivers
- HtmlUnitDriver does not fully support Mouse interactions 
- PhantomJSDriver does not fully support javascript Alerts

###### Requirement
* Java 8: The used version of Selenium WebDriver requires Java 8

#### Parameterized
Given there are several modes in which the `sj:head` tag can be configured, the same tests are run for several configurations.
To do this, the `@RunWith(Parameterized.class)` annotation is used, in an effort to prevent duplicating the exact same test for multiple configuration.

###### Current configurations
- `regular`
  - `<sj:head/>`
- `loadatonce`
  - `<sj:head loadAtOnce="true"/>`
- `loadfromgoogle`
  - `<sj:head loadFromGoogle="true"/>`
- `uncompressed`
  - `<sj:head compressed="false"/>`

#### Profiles
In order to be able to switch between WebDriver implementation used for the tests, maven profiles are used.

###### default profile
* Uses HtmlUnitDriver
* should be able to run on any machine

###### phantomjs profile
* name: `phantomjs`
* Uses PhantomJSDriver
* requires phantomjs to be installed and configured on the path

#### Categories
In order to filter which tests should be executed, `JUnit @Category` is being used.
Currently 2 categories are defined:
- `HtmlUnitCategory` : used to filter tests that need to be run with the HtmlUnitDriver
- `PhantomJSCategory` : used to filter tests that need to be run with the PhantomJSDriver

## How to run the tests

#### HtmlUnitDriver tests

###### Run all tests
    mvn verify

###### Run all tests in a single TestClass
    mvn verify -Dit.test=ATagIT

###### Run a single test for all modes
    mvn verify -Dit.test=ATagIT#testSimpleAjaxPageLink[*]

###### Run a single test for a single mode
    mvn verify -Dit.test=ATagIT#testSimpleAjaxPageLink[0]

#### PhantomJSDriver tests

###### Requirements
- phantomjs installed
- phantomjs configured on path

###### Run all tests
    mvn -P phantomjs verify

###### Run all tests in a single TestClass
    mvn -P phantomjs verify -Dit.test=ATagIT

###### Run a single test for all modes
    mvn -P phantomjs verify -Dit.test=ATagIT#testSimpleAjaxPageLink[*]

###### Run a single test for a single mode
    mvn -P phantomjs verify -Dit.test=ATagIT#testSimpleAjaxPageLink[0]

