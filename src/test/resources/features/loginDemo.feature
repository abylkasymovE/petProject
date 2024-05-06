Feature: test login functionality

  @loginDemo
  Scenario: check log in successful with valid credentials
    Given user is on sauce demo login page
    When user provides a valid username
    And user provides a valid password
    And user clicks on login button
    Then verify user successfully logged in

  @loginDemo
  Scenario: user logs in with invalid credentials
    Given user is on sauce demo login page
    When user provides a invalid username
    And user provides a invalid password
    And user clicks on login button
    Then verify user sees an error message