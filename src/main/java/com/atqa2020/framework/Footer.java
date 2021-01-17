package com.atqa2020.framework;

import com.atqa2020.pages.CustomerServicePage;
import com.atqa2020.pages.FindJobsPage;
import com.atqa2020.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Footer extends GeneralElements {

    protected RemoteWebDriver driver;
    private String customerServiceLinkLocator = "//div[@class='navFooterLinkCol navAccessibility'][4]//a[contains(text(),'Service')]";
    private String careersLinkLocator = "//a[contains(text(),'Careers')]";

    public Footer(final RemoteWebDriver driver) {
        this.driver = driver;
    }

    public <T extends Page>T navigateTo(Class<T> clazz, String xpath) throws Exception {
        driver.findElement(By.xpath(xpath)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public CustomerServicePage navigateToCustomerService() throws Exception {
        driver.findElement(By.xpath(customerServiceLinkLocator)).click();
        return PageFactory.newPage(driver, CustomerServicePage.class);
    }

    public FindJobsPage navigateToFindJobsPage() throws Exception {
        driver.findElement(By.xpath(careersLinkLocator)).click();
        return PageFactory.newPage(driver, FindJobsPage.class);
    }
}
