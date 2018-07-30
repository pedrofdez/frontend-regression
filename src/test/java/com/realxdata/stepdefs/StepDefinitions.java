package com.realxdata.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Initializing browser driver");
        System.setProperty("webdriver.chrome.driver", "/Users/pedro/workspace/intellij/rxd-frontend-bdd/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^I am on the login page$")
    public void givenIAmOnTheLogInPage() {
        driver.get("https://test.realxdata.com?locale=en");
        new WebDriverWait(driver, 2L).until(webDriver ->
            ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

    }

    @When("^I enter a(?: non existing)? user \\[user:(.+)]$")
    public void whenIEnterAUser(String username) {
        WebElement userInput = driver.findElement(By.id("user_email"));
        userInput.clear();
        userInput.sendKeys(username);
    }

    @When("^I enter a(?: wrong)? password \\[password:(.+)]$")
    public void whenIEnterAPassword(String password) {
        WebElement passwordInput =  driver.findElement(By.id("user_password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    @When("^I click on the login button$")
    public void whenIClickOnTheLoginButton() {
        WebElement loginForm = driver.findElement(By.id("new_user"));
        loginForm.submit();

    }

    @Then("^the dashboard is loaded$")
    public void thenTheDashboardIsLoaded() {
        new WebDriverWait(driver,10L).until( d -> d.findElement(By.id("dashboard")).isDisplayed());
    }

    @Then("^the dashboard is not loaded$")
    public void thenTheDashboardIsNotLoaded() {
        assertThat(driver.findElements(By.id("dashboard")).size())
            .isZero();
    }

    @Then("^an error is shown on the form$")
    public void thenAnErrorMessageIsShownOnTheForm() {
        WebElement form = driver.findElement(By.id("new_user"));
        assertThat(form.getText())
            .contains("Invalid Email or password.");
    }

    @Then("^big numbers have the following values$")
    public void thenBigNumbersHaveValues(Map<String, String> values) {

        for(Map.Entry<String, String> entry : values.entrySet()) {
            assertThat(driver.findElement(By.id(entry.getKey())).getText())
                .contains(entry.getValue());
        }
    }
}
