package com.atqa2020.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

public class NewReleasesPage extends Page {
    public String anyDepartmentListLocator = "//ul[@id='zg_browseRoot']//ul[1]//li";
    public String newReleasesNamesOfItemsListLocator = "//*[@class='zg_homeWidget']/h3";

    public NewReleasesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isThereNewReleasesItemsInAnyDepartmentList() {
        ArrayList<String> hotReleasesList = new ArrayList<>();
        ArrayList<String> anyDepartmentList = new ArrayList<>();
        List<WebElement> newReleasesItemsList = driver.findElements(By.xpath(newReleasesNamesOfItemsListLocator));
        List<WebElement> anyDepartmentItemsList = driver.findElements(By.xpath(anyDepartmentListLocator));
        for (WebElement element : anyDepartmentItemsList) {
            anyDepartmentList.add(element.getText());
        }
        for (WebElement element : newReleasesItemsList) {
            hotReleasesList.add(element.getText());
        }
            return anyDepartmentList.containsAll(hotReleasesList);
        }
}


