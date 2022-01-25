package demo.spring.selenium.stepdefinitions;

import demo.spring.selenium.SpringContextConfiguration;
import demo.spring.selenium.config.DemoSpringSeleniumProperties;
import demo.spring.selenium.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.ITestContext;

@CucumberContextConfiguration
@SpringBootTest(classes = {SpringContextConfiguration.class})
@Slf4j
public class Hooks {

  @Autowired private DemoSpringSeleniumProperties properties;

  @Autowired private WebDriver driver;

  @Autowired
  private LoginSteps loginSteps;

  @Autowired
  private HomePage homePage;

  @Before
  public void openBrowser(Scenario scenario) {
    driver.get(properties.getHost());
    log.info("[STARTED] Scenario: " + scenario.getName());
  }



  @After(order = 0)
  public void closeBrowser(Scenario scenario) {
    driver.quit();
    log.info("[ENDED] Scenario: " + scenario.getName());
  }

  @After(order = 1)
  public void takeScreen(Scenario scenario) {
    if(scenario.isFailed()) {
      //TODO do screenshot only when scenario is
      byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenshot, "image/png", scenario.getName());
    }
  }

  @Before(value = "@OpenLoginPage")
  public void testTag() {
    homePage.clickFormAuthentication();
  }

  @Before(value = "@Auth")
  public void auth() {
    //TODO auth

  }
}
