package com.atqa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CustomerServicePage extends Page {

    private static String CONTACT_PAGE_TITLE = "Hello. What can we help you with?";
    public static String PAGE_URL = "gp/help/customer/display.html";
    private String contactPageTitleLocator = "//h1[contains(text(),'Hello')]";

    public CustomerServicePage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isTitleCorrect() {
        return driver.findElement(By.xpath(contactPageTitleLocator)).getText().equals(CONTACT_PAGE_TITLE);
    }
}
