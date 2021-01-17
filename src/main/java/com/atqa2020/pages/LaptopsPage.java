package com.atqa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LaptopsPage extends Page {

    private String searchTermLocator = "//*[@class='a-color-state a-text-bold']";

    public LaptopsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isSearchTermValid(String searchTerm) {
        return driver.findElement(By.xpath(searchTermLocator)).getText().contains(searchTerm);
    }
}
