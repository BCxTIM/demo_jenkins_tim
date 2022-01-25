@OpenLoginPage
Feature: Test

  Scenario:
    When I fill the username with "tomsmith"
    And I fill the password with "SuperSecretPassword!"
    And I click on Login
    Then I see "You logged into a secure area!" message


  Scenario:
    When I fill the username with "tomsmith"
    And I fill the password with "SuperSecretPassword!"
    And I click on Login
    Then I see "You logged into a secure area!" message