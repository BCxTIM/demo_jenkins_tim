package demo.spring.selenium.stepdefinitions;

import demo.spring.selenium.models.UserCredentials;
import demo.spring.selenium.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LoginSteps {

  @Autowired
  private LoginPage loginPage;

  @DataTableType
  public UserCredentials userCredentials(Map<String, String> entry) {
    return new UserCredentials(entry.get("username"), entry.get("password"), entry.get("text"));
  }

  @When("^I fill the username with \"(.*)\"$")
  public void iFillTheUsernameInputWith(String username) {
    loginPage.typeUsername(username);
  }

  @When("^I fill the password with \"(.*)\"$")
  public void iFillThePasswordInputWith(String password) {
    loginPage.typePassword(password);
  }

  @When("^I click on Login$")
  public void iClickOnLoginButton() {
    loginPage.clickLogin();
  }

  @When("^I login as (valid|invalid) user with following credentials as List:$")
  public void loginAsUserWithFollowingCredentials(String isValid, List<String> credentials) {
    loginPage.typeUsername(credentials.get(0));
    loginPage.typePassword(credentials.get(1));
    loginPage.clickLogin();
  }

  @When("^I login as (valid|invalid) user with following credentials:$")
  public void loginAsUserWithFollowingCredentials(String isValid, Map<String, String> credentials) {
    loginPage.typeUsername(credentials.get("username"));
    loginPage.typePassword(credentials.get("password"));
    loginPage.clickLogin();
  }

  @When("^I login as (valid|invalid) user with following credentials as DataTable:$")
  public void loginAsUserWithFollowingCredentials(String isValid, DataTable credentials) {
    List<Map<String, String>> table = credentials.asMaps();

    loginPage.typeUsername(table.get(0).get("username"));
    loginPage.typePassword(table.get(0).get("password"));
    loginPage.clickLogin();
  }

  @When("^I login as (valid|invalid) user with following credentials as Custom Object:$")
  public void loginAsUserWithFollowingCredentialsWithCustomObject(String isValid, UserCredentials userCredentials) {
    loginPage.typeUsername(userCredentials.getUsername());
    loginPage.typePassword(userCredentials.getPassword());
    loginPage.clickLogin();
  }

  @Given("login as valid user")
  public void loginAsValidUser() {
    loginPage.typeUsername("some user cred");
    loginPage.typePassword("some user cred");
    loginPage.clickLogin();
  }
}
