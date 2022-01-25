@login
Feature: Login

  Background:
    Given login as valid user


  @smoke
  Scenario: Login successfully
    Given I open Login Page
    When I fill the username with "tomsmith"
    And I fill the password with "SuperSecretPassword!"
    And I click on Login
    Then I see "You logged into a secure area!" message

  @sanity
  Scenario: Login with invalid user
    Given I open Login Page
    When I fill the username with "invalid"
    And I fill the password with "SuperSecretPassword!"
    And I click on Login
    Then I see "Your username is invalid!" message

  @failed
  Scenario: Login with invalid user failed
    Given I open Login Page
    When I fill the username with "invalid"
    And I fill the password with "SuperSecretPassword!"
    And I click on Login
    Then I see "You logged into a secure area!" message

  Scenario Outline: Validation fields
    Given I open Login Page
    When I fill the username with "<loginField>"
    And I fill the password with "<passwordField>"
    And I click on Login
    Then I see "Your username is invalid!" message

    Examples:
      | loginField | passwordField        |
      | invalid    | SuperSecretPassword! |
      |            |                      |
      | s          | s                    |

  Scenario: Scenario with List data.
    Given I open Login Page
    When I login as valid user with following credentials as List:
      | someUserName |
      | somePassword |
    Then I see "Your username is invalid!" message

  Scenario: Scenario with Map data.
    Given I open Login Page
    When I login as valid user with following credentials:
      | username | someUserName |
      | password | somePassword |
    Then I see "Your username is invalid!" message

  Scenario: Scenario with DataTable
    Given I open Login Page
    When I login as valid user with following credentials as DataTable:
      | username     | password     |
      | someUserName | somePassword |
    Then I see "Your username is invalid!" message


  Scenario: Scenario with User object
    Given I open Login Page
    When I login as valid user with following credentials as Custom Object:
      | username     | password     | text     |
      | someUserName | somePassword | someText |
    Then I see "Your username is invalid!" message