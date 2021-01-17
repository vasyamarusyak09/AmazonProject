package com.atqa2020.pages;

import com.atqa2020.framework.utils.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BestSellersPage extends Page {

    private String bestSellersItemListLocator = "//*[@class='a-section a-spacing-none p13n-asin']//a";

    public BestSellersPage(RemoteWebDriver driver) {
        super(driver);
    }

    public String getFirstBestSellerTitle() {
        return getElements(By.xpath(bestSellersItemListLocator)).get(0).getText();
    }

    public BestSellerItemPage navigateToFirstBestSellerItemPage() throws Exception {
        getElements(By.xpath(bestSellersItemListLocator)).get(0).click();
        return PageFactory.newPage(driver, BestSellerItemPage.class);
    }


}
