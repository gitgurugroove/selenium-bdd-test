@OpenCart
Feature: To Automate the OpenCart Website for all its features


  Background: The User lands on the OpenCart Homepage
    Given the user is on the OpenCart homepage

  @Login
  Scenario: User logs into OpenCart with Valid Credentials
    Given the user is on the OpenCart login page
    When they enter valid credentials and click on login
    Then they should be redirected to the  my account dashboard
