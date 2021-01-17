package com.atqa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class JobSearchResultsPage extends Page {

    private String resultsListLocator = "//div[@class='job-tile-lists col-12']//div[@class='job-tile']";

    public JobSearchResultsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isSearchCorrect(String searchTerm) {
        return isSearchTermPresented(searchTerm);
    }

    private boolean isSearchTermPresented(String searchTerm) {
        boolean result = false;

        List<WebElement> results = getElements(By.xpath(resultsListLocator));

        for (WebElement element : results){
            result = element.findElement(By.xpath(".//h3")).getText().toLowerCase().contains(searchTerm);
            if (!result) {
                break;
            }
        }

        return result;
    }
}
