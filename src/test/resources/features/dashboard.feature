@wip
Feature: dashboard

  Background:
    Given I am on the login page
    When I enter a user [user:testey@realxdata.com]
    And I enter a password [password:test10]
    And I click on the login button
    Then the dashboard is loaded

  Scenario: 1. Big Numbers
    Then big numbers have the following values
      | rentValue      | 198M    |
      | vacancyValue   | 10,3%   |
      | waltValue      | 3,8 yrs |
      | assetsValue    | 1,23k   |
      | tenantsValue   | 29,7k   |
      | locationsValue | 126     |
      | areaValue      | 2,87M   |
