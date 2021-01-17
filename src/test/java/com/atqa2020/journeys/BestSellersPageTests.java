package com.atqa2020.journeys;

import com.atqa2020.BaseTest;
import com.atqa2020.pages.BestSellerItemPage;
import com.atqa2020.pages.BestSellersPage;
import com.atqa2020.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BestSellersPageTests extends BaseTest {

    private String acceptCookiesButtonLocator = "//input[@id='sp-cc-accept']";
    private HomePage homePage;
    private BestSellersPage bestSellersPage;
    private BestSellerItemPage bestSellerItemPage;

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        if (driver.findElement(By.xpath(acceptCookiesButtonLocator)).isDisplayed()) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }

        homePage = new HomePage(driver);
    }

    @Test(groups = "main", suiteName = "ui")
    public void firstBestSellerItemTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user clicks on Customer Service link he is redirected to the Contact Us page
        bestSellersPage = homePage.navigateToBestSellersPage();

        String expectedTitle = bestSellersPage.getFirstBestSellerTitle();

        bestSellerItemPage = bestSellersPage.navigateToFirstBestSellerItemPage();
        //And

        //Then title should be as expected
        Assert.assertTrue(bestSellerItemPage.isBestItemTitleCorrect(expectedTitle), "Title is not correct!!!");
    }
}
