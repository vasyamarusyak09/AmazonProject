package com.atqa2020.stepdefinitions;

import com.atqa2020.BaseTest;
import com.atqa2020.framework.utils.Helper;
import com.atqa2020.pages.CustomerServicePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CustomerServicePageDef extends BaseTest {

    private CustomerServicePage customerServicePage;
    private String acceptCookiesButtonLocator = "//input[@id='sp-cc-accept']";

    @Before
    public void setupTest() {
        setup();
        if (isElementDisplayed(By.xpath(acceptCookiesButtonLocator))) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
    }

    @After
    public void cleanTest() {
        tearDown();
    }

    @Given("User is on the Home page")
    public void userIsOnTheHomePage() {
        Helper.Logger.LogInfo("User is on the Home page");
    }

    @When("User click on Customer Service link")
    public void userClickOnCustomerServiceLink() throws Exception {
        customerServicePage = pageNavigator.navigateToCustomerService();
    }

    @Then("User is redirected to the Customer Service page")
    public void userIsRedirectedToTheCustomerServicePage() {
        Assert.assertTrue(customerServicePage.isTitleCorrect(), "Title is not correct!!!");
    }
}
