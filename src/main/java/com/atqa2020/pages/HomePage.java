package com.atqa2020.pages;

import com.atqa2020.framework.universalelements.Footer;
import com.atqa2020.framework.universalelements.Header;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends Page {

    private Header header;
    private Footer footer;


    public HomePage(RemoteWebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        this.footer = new Footer(driver);
    }

    public <T extends Page>T navigateToPage(Class<T> clazz, String xpath) throws Exception {
        return footer.navigateTo(clazz, xpath);
    }

    public <T extends Page> T searchForItem(Class<T> clazz, String searchTerm) throws Exception {
        return header.setSearchTerm(searchTerm).clickOnSearchButton(clazz);
    }

    public BestSellersPage navigateToBestSellersPage() throws Exception {
        return header.clickOnBestSellersLink();
    }

    public NewReleasesPage navigateToNewReleasesPage() throws Exception {
        return header.clickOnNewReleasesLink();
    }
}
