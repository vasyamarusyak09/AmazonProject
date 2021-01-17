package com.atqa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FindJobsPage extends Page {

    public static String PAGE_URL = "https://www.amazon.jobs/en-gb";
    private String searchFieldLocator = "//div[@class='col-12 col-md-8']//span[@class='twitter-typeahead']//input";
    private String searchButtonLocator = "//*[@id='search-button']";

    public FindJobsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public FindJobsPage setSearchTerm(String searchTerm) {
        return setText(By.xpath(searchFieldLocator), searchTerm, FindJobsPage.class);
    }

    public JobSearchResultsPage clickSearch() throws Exception {
        return clickOnElement(By.xpath(searchButtonLocator), JobSearchResultsPage.class);
    }



}
