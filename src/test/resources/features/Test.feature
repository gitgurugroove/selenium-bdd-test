Feature: Test login functionality

  @SmokeTest
  Scenario: Successful login with Valid Credentials
    Given User navigate to the login page
    When User enters valid credentials
    Then User should be on the login page
