package com.atqa2020.journeys;

import com.atqa2020.BaseTest;
import com.atqa2020.framework.utils.DataProvider;
import com.atqa2020.listeners.TestListener;
import com.atqa2020.pages.CustomerServicePage;
import com.atqa2020.pages.HomePage;
import com.atqa2020.pages.LaptopsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ContactPageTests extends BaseTest {

    private String acceptCookiesButtonLocator = "//input[@id='sp-cc-accept']";

//    private String searchTerm = "laptop";

    private HomePage homePage;
    private CustomerServicePage customerServicePage;
    private LaptopsPage laptopsPage;


    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        if (isElementDisplayed(By.xpath(acceptCookiesButtonLocator))) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
        homePage = new HomePage(driver);
    }

    @org.testng.annotations.DataProvider(name = "getSearchTerms")
    public Object[][] getSearchTerms() {
        return DataProvider.getAllSearchTerms();
    }

    @Test(groups = "main", suiteName = "ui")
    public void contactPageTest() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user clicks on Customer Service link he is redirected to the Contact Us page
        customerServicePage = pageNavigator.navigateToCustomerService();
        //And

        //Then title should be as expected
        Assert.assertTrue(customerServicePage.isTitleCorrect(), "Title is not correct!!!");
    }

    @Test(groups = "main", suiteName = "ui")
    public void contactPageTestViaUrl() throws Exception {

        //Given user opens a browser and provides a valid url

        //When user clicks on Customer Service link he is redirected to the Contact Us page
        customerServicePage = pageNavigator.navigateToPageViaUrl(CustomerServicePage.class, CustomerServicePage.PAGE_URL, true);
        //And

        //Then title should be as expected
        Assert.assertTrue(customerServicePage.isTitleCorrect(), "Title is not correct!!!");
    }

    @Test(groups = "main", dataProvider = "getSearchTerms")
    public void searchTest(String searchTerm) throws Exception {

        //Given user opens a browser and provides a valid url

        //When user provides a search term "laptop" and clicks on search button
        laptopsPage = homePage.searchForItem(LaptopsPage.class, searchTerm);

        //Then search term on the results page is "laptop"
        Assert.assertTrue(laptopsPage.isSearchTermValid(searchTerm), "Search term is not valid!");
    }
}
