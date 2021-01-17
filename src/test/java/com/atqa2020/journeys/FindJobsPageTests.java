package com.atqa2020.journeys;

import com.atqa2020.BaseTest;
import com.atqa2020.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindJobsPageTests extends BaseTest {

    private String acceptCookiesButtonLocator = "//input[@id='sp-cc-accept']";
    private HomePage homePage;
    private FindJobsPage findJobsPage;
    private JobSearchResultsPage jobSearchResultsPage;


    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        if (driver.findElement(By.xpath(acceptCookiesButtonLocator)).isDisplayed()) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
        homePage = new HomePage(driver);
    }

    @Test(groups = "main", suiteName = "ui")
    public void findJobsPageSearchTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user clicks on Customer Service link he is redirected to the Contact Us page
        findJobsPage = pageNavigator.navigateToFindJobsPage().setSearchTerm("test");
        //And

        jobSearchResultsPage = findJobsPage.clickSearch();

        //Then title should be as expected
        Assert.assertTrue(jobSearchResultsPage.isSearchCorrect(getProperty("test.searchTerm")), "Search is not correct!!!");
    }

    @Test(groups = "main", suiteName = "ui")
    public void findJobsPageSearchTestViaUrl() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user clicks on Customer Service link he is redirected to the Contact Us page
        findJobsPage = pageNavigator.navigateToPageViaUrl(FindJobsPage.class, FindJobsPage.PAGE_URL, false).setSearchTerm("test");
        //And

        jobSearchResultsPage = findJobsPage.clickSearch();

        //Then title should be as expected
        Assert.assertTrue(jobSearchResultsPage.isSearchCorrect(getProperty("test.searchTerm")), "Search is not correct!!!");
    }
}
