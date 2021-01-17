package com.atqa2020.framework.utils;

import com.atqa2020.framework.universalelements.Footer;
import com.atqa2020.framework.universalelements.Header;
import com.atqa2020.pages.CustomerServicePage;
import com.atqa2020.pages.FindJobsPage;
import com.atqa2020.pages.NewReleasesPage;
import com.atqa2020.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageNavigator {

    private RemoteWebDriver driver;
    private Header header;
    private Footer footer;
    private String baseUrl;

    public PageNavigator(RemoteWebDriver driver, String baseUrl) {
        this.driver = driver;
        this.header = new Header(driver);
        this.footer = new Footer(driver);
        this.baseUrl = baseUrl;
    }

    public <T extends Page>T navigateToPage(Class<T> clazz, String xpath) throws Exception {
        driver.findElement(By.xpath(xpath)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public <T extends Page>T navigateToPageViaUrl(Class<T> clazz, String url, boolean isBaseUrl) throws Exception {
        if (isBaseUrl) {
            driver.get(baseUrl + url);
        } else {
            driver.get(url);
        }
        return PageFactory.newPage(driver, clazz);
    }

    public CustomerServicePage navigateToCustomerService() throws Exception {
        return footer.navigateToCustomerService();
    }

    public FindJobsPage navigateToFindJobsPage() throws Exception {
        return footer.navigateToFindJobsPage();
    }

    public NewReleasesPage navigateToNewReleasesPage() throws Exception {
        return header.clickOnNewReleasesLink();
    }
}
