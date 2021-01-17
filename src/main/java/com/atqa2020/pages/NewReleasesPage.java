package com.atqa2020.pages;
import com.atqa2020.framework.utils.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;

public class NewReleasesPage extends Page {
//
//    private ArrayList<String> AllLeftMenuNames;
//    private ArrayList<String> AllNamesItemList;

    public NewReleasesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public String getAllLeftMenuNames() {
        String newReleasesLeftMenuNamesLIstLocator = "//ul[@id='zg_browseRoot']/ul/li/a";
//        AllLeftMenuNames = new ArrayList<String>();
//        System.out.println(AllLeftMenuNames);
        return getElements(By.xpath(newReleasesLeftMenuNamesLIstLocator)).get(0).getText();
    }

    public String getAllNamesItemList() {
        String newReleasesNamesItemListLocator = "//*[@class='zg_homeWidget']/h3";
//        AllNamesItemList = new ArrayList<String>();
//        System.out.println(AllNamesItemList);
        return getElements(By.xpath(newReleasesNamesItemListLocator)).get(0).getText();
    }

//    public boolean isLeftMenuListContains() {
//        return AllLeftMenuNames.containsAll(AllNamesItemList);
//    }

}

