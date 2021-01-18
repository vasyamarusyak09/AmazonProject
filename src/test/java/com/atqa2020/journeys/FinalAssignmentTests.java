package com.atqa2020.journeys;

import com.atqa2020.BaseTest;
import com.atqa2020.framework.universalelements.Header;
import com.atqa2020.listeners.TestListener;
import com.atqa2020.pages.HomePage;
import com.atqa2020.pages.NewReleasesPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
@Listeners(TestListener.class)

public class FinalAssignmentTests extends BaseTest {

    private String acceptCookiesButtonLocator = "//input[@id='sp-cc-accept']";
    private Header header;
    private HomePage homePage;
    public NewReleasesPage newReleasesPage ;


    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        if (isElementDisplayed(By.xpath(acceptCookiesButtonLocator))) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
        homePage = new HomePage(driver);
    }

    @Test(groups = "main1", suiteName = "ui")
    public void newReleasesComparingTest() throws Exception {
        header = homePage.openLeftSideMenu();
        newReleasesPage = homePage.navigateToNewReleasesPage();
        Assert.assertTrue(newReleasesPage.isThereNewReleasesItemsInAnyDepartmentList(), "List of any department titles does not include all hot new releases titles");

    }
}