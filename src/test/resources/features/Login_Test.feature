@Login_Functionality
Feature: Test login functionality

  @Valid
  Scenario: Successful login with Valid Credentials
    Given User navigate to the login page
    When User enters valid credentials
    Then User should be on the login page
    Then I should see a message saying "Logged In Successfully"
    And I should see the Log out button

  @InvalidUser
  Scenario: Login Un-successful with Invalid Username
    Given User navigate to the login page
    When User enters Invalid Username and Valid Password
    Then Login Error message is displayed and message is "Your username is invalid!"

  @InvalidPassword
  Scenario: Login Un-successful with Invalid Password
    Given User navigate to the login page
    When User enters valid Username and invalid Password
    Then Login Error message is displayed and message is "Your password is invalid!"