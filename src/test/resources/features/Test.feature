Feature: Test login functionality

  @PositiveTest
  Scenario: Successful login with Valid Credentials
    Given User navigate to the login page
    When User enters valid credentials
    Then User should be on the login page
    Then I should see a message saying "Logged In Successfully"
    And I should see the Log out button