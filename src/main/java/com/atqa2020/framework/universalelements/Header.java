package com.atqa2020.framework.universalelements;

import com.atqa2020.framework.utils.PageFactory;
import com.atqa2020.pages.BestSellersPage;
import com.atqa2020.pages.HomePage;
import com.atqa2020.pages.NewReleasesPage;
import com.atqa2020.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Header extends GeneralElements {

    protected RemoteWebDriver driver;

    private String searchFieldLocator = "//input[@id='twotabsearchtextbox']";
    private String searchButtonLocator = "//span[@id='nav-search-submit-text']";
    private String bestSellersLinkLocator = "//*[@data-csa-c-slot-id='nav_cs_1']";
    private String allButtonLocator = "//div[@class='nav-left']/a[1]";
    private String newReleasesLinkLocator = "//ul[@class='hmenu hmenu-visible']//a[text() = 'New Releases']";

    public Header(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public Header setSearchTerm(String searchTerm) {
        driver.findElement(By.xpath(searchFieldLocator)).sendKeys(searchTerm);
        return this;
    }

    public <T extends Page> T clickOnSearchButton(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(searchButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public BestSellersPage clickOnBestSellersLink() throws Exception {
        driver.findElement(By.xpath(bestSellersLinkLocator)).click();
        return PageFactory.newPage(driver, BestSellersPage.class);
    }

    public Header navigateToLeftSideMenuAll() {
        driver.findElement(By.xpath(allButtonLocator)).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }
    public <T extends Page> T navigateToNewReleasesPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(newReleasesLinkLocator)).click();
        return com.atqa2020.framework.utils.PageFactory.newPage(driver, clazz);
    }

}
