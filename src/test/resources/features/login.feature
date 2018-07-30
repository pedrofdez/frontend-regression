Feature: Login page

  Scenario: 1. Log in with an existing user
    Given I am on the login page
    When I enter a user [user:test@realxdata.com]
    And I enter a password [password:test10]
    And I click on the login button
    Then the dashboard is loaded

  Scenario: 2. Log in with non existing user
    Given I am on the login page
    When I enter a non existing user [user:nothere@realxdata.com]
    And I enter a password [password:test]
    And I click on the login button
    Then the dashboard is not loaded
    And an error is shown on the form

  Scenario: 3. Log in with incorrect password
    Given I am on the login page
    When I enter a user [user:test@realxdata.com]
    And I enter a wrong password [password:incorrect]
    And I click on the login button
    Then the dashboard is not loaded
    And an error is shown on the form
