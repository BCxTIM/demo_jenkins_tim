@loginWithBackground
Feature: Login with background


  Background: Open Login Page
    Given I open Login Page

  @smoke
  Scenario: Login successfully
    When I fill the username with "tomsmith"
    And I fill the password with "SuperSecretPassword!"
    And I click on Login
    Then I see "You logged into a secure area!" message

  @sanity
  Scenario: Login with invalid user
    When I fill the username with "invalid"
    And I fill the password with "SuperSecretPassword!"
    And I click on Login
    Then I see "Your username is dsadasda!" message