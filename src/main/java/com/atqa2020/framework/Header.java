package com.atqa2020.framework;

import com.atqa2020.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Header extends GeneralElements {

    protected RemoteWebDriver driver;

    private String searchFieldLocator = "//input[@id='twotabsearchtextbox']";
    private String searchButtonLocator = "//span[@id='nav-search-submit-text']";
    private String bestSellersLinkLocator = "//*[@data-csa-c-slot-id='nav_cs_1']";
    private String allElementLinklocator = "//*[@id='nav-hamburger-menu']";
    private String newReleasesLinkLocator = "//*[@class='hmenu hmenu-visible']/li[3]";


    public Header(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public Header setSearchTerm(String searchTerm) {
        driver.findElement(By.xpath(searchFieldLocator)).sendKeys(searchTerm);
        return this;
    }
    public HomePage clickOnAllLink() throws Exception {
        driver.findElement(By.xpath(allElementLinklocator)).click();
        return PageFactory.newPage(driver, HomePage.class);
    }

    public <T extends Page> T clickOnSearchButton(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(searchButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public BestSellersPage clickOnBestSellersLink() throws Exception {
        driver.findElement(By.xpath(bestSellersLinkLocator)).click();
        return PageFactory.newPage(driver, BestSellersPage.class);
    }

    public NewReleasesPage clickOnNewReleasesLink() throws Exception {
        driver.findElement(By.xpath(newReleasesLinkLocator)).click();
        return PageFactory.newPage(driver, NewReleasesPage.class);
    }
}
