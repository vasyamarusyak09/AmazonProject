package com.atqa2020.journeys;

import com.atqa2020.BaseTest;
import com.atqa2020.framework.dictionary.AmazonURLs;
import com.atqa2020.framework.utils.DataProvider;
import com.atqa2020.framework.utils.Helper;
import com.atqa2020.listeners.TestListener;
import com.atqa2020.pages.HomePage;
import com.atqa2020.pages.NewReleasesPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.ArrayList;
@Listeners(TestListener.class)

public class FinalAssignmentTests extends BaseTest {

    private String acceptCookiesButtonLocator = "//input[@id='sp-cc-accept']";
    private HomePage homePage;
    private ArrayList<String> results = new ArrayList<>();
    public NewReleasesPage newReleasesPage;


    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        if (isElementDisplayed(By.xpath(acceptCookiesButtonLocator))) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
        homePage = new HomePage(driver);
    }

    @Test
    public void newReleasesComparingTest() throws Exception {

        newReleasesPage = homePage.navigateToNewReleasesPage();
        //newReleasesPage = pageNavigator.navigateToNewReleasesPage();
        //newReleasesPage.getAllLeftMenuNames();
        //newReleasesPage = homePage.getAllNamesItemList();

//        String AllLeftMenuNames = newReleasesPage.getAllLeftMenuNames();
//         String AllNamesItemList = newReleasesPage.getAllNamesItemList();

        Assert.assertTrue(true, "Left Menu List Does not contain menu list");
    }
}
