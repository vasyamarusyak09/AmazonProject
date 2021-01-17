package com.atqa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BestSellerItemPage extends Page {

    private String bestItemTitleLocator = "//span[@id='productTitle' or @id='gc-asin-title']";

    public BestSellerItemPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isBestItemTitleCorrect(String expectedTitle) {
        return getElement(By.xpath(bestItemTitleLocator)).getText().equals(expectedTitle);
    }
}
