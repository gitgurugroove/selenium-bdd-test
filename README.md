# Selenium Java BDD Automation Test Suite

## Overview
This project is a **Selenium Java BDD (Behavior-Driven Development)** automation test suite designed to automate a sample login page. The test suite is built using the **Cucumber** framework with **Gherkin syntax** to define feature files, and it integrates **Selenium WebDriver** to execute the tests on different browsers.

The purpose of this test suite is to provide a ready-made automation framework for **automation testers**, enabling them to test a login functionality using multiple browsers like **Chrome**, **Firefox**, etc.

### Test URL:
The test is performed on the following URL:

- **[Practice Test Automation Login Page](https://practicetestautomation.com/practice-test-login/)**

## Key Features
- **BDD (Behavior-Driven Development)**: Tests are written using Cucumber and Gherkin syntax to ensure easy readability and collaboration between developers and non-developers.
- **Selenium WebDriver**: Used for browser automation, allowing the suite to run across multiple browsers.
- **Browser Flexibility**: The suite can be easily configured to run on different browsers like Chrome, Firefox, and more.
- **Page Object Model (POM)**: The test structure is designed using the Page Object Model for better code maintainability and reusability.
- **JUnit Runner**: Executes the tests with the help of Cucumber's JUnit integration.
- **Reporting**: Generates comprehensive HTML and JSON reports to track the status of test execution.

## Technologies Used
- **Java**: Programming language for writing automation scripts.
- **Selenium WebDriver**: Tool for interacting with web browsers.
- **Cucumber**: Framework for writing BDD-style tests.
- **Gradle**: Build tool for compiling and running tests.
- **JUnit**: Test runner for executing the Cucumber scenarios.


## Setup and Execution

### Prerequisites
- **Java JDK** (version 8 or above)
- **Gradle** (or you can use the Gradle wrapper provided in the project)
- **ChromeDriver** or **GeckoDriver** (for Chrome and Firefox browsers, respectively)
- **IntelliJ IDEA** or any Java IDE with Gradle support
- **WebDriverManager** to automatically manage browser driver binaries

### Project Structure
- **`src/test/java`**: Contains the step definitions and utility files.
- **`src/test/resources`**: Contains the feature files written in Gherkin syntax.
- **`src/main/java`**: Contains the page object model classes for different pages.

### How to Run the Tests
#### 1. Clone the Repository
```bash
git clone <repository-url>
```

#### 2. Navigate to the Project Directory
```bash
cd selenium-bdd-test
```

#### 3. Run Tests Using Gradle
- To execute the tests on **Chrome** (default):
```bash
gradle clean test
```

- To execute the tests on **Firefox**, set the browser property:
```bash
gradle clean test -Dbrowser=firefox
```

#### 4. View Reports
- After the tests are executed, reports are generated in the `target` folder.
    - HTML Report: `target/cucumber-reports.html`
    - JSON Report: `target/cucumber-reports.json`

### Running Tests in Different Browsers
This suite supports running tests on multiple browsers. By default, it runs on **Chrome**, but you can switch to another browser like **Firefox** by setting the system property:

```bash
-Dwebdriver.gecko.driver=<path_to_geckodriver>
```

### Test Scenarios
The suite automates the following test cases:
1. **Successful Login**: A valid user logs in using the correct credentials (`student/Password123`).
2. **Verify Login Page URL**: After login, the test ensures the URL is correct.
3. **Verify Success Message**: Checks that the message "Congratulations student. You successfully logged in!" is displayed.
4. **Verify Log out Button**: Ensures that the "Log out" button is displayed on the post-login page.

### Browser Setup
- **ChromeDriver** and **GeckoDriver** can be automatically managed using **WebDriverManager** in the test suite. This allows the test suite to fetch the appropriate driver versions automatically.

### Dependencies
- The following dependencies are required for this project and are managed through Gradle:
    - `Selenium WebDriver`
    - `Cucumber`
    - `JUnit`
    - `WebDriverManager`

You can find these in the `build.gradle` file.

### Example Feature File

```gherkin
Feature: Login to Practice Test Automation

  Scenario: Successful login with valid credentials
    Given I navigate to the login page
    When I enter valid username and password
    And I click the login button
    Then I should see a message saying "Congratulations" or "successfully logged in"
    And I should see the Log out button
```

### Customizing the Test
- **Change Browser**: You can run the test on a different browser by modifying the `-Dbrowser` option.
- **Add New Scenarios**: Simply add new scenarios to the existing feature files and define the steps in the step definitions.

### License
This project is open-source and free to use under the **MIT License**.

---

This README provides detailed guidance on how to set up, run, and customize the test suite. Let me know if you need any additional information or modifications!