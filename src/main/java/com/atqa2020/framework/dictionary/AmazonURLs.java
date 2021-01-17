package com.atqa2020.framework.dictionary;

import com.atqa2020.pages.AboutUsPage;
import com.atqa2020.pages.FindJobsPage;
import com.atqa2020.pages.SellOnAmazonPage;

public enum AmazonURLs {

    ABOUT_US_URL(AboutUsPage.class, "https://www.aboutamazon.co.uk/", "//a[text()='About Us']"),
    CAREERS_URL(FindJobsPage.class, "https://www.amazon.jobs/", "//a[contains(text(),'Careers')]"),
    SELL_ON_AMAZON_URL(SellOnAmazonPage.class, "https://sell.amazon.co.uk/", "//div[@class='navFooterLinkCol navAccessibility']//a[text()='Sell on Amazon']");

    private final Class clazz;
    private final String url;
    private final String xpath;

    AmazonURLs(Class clazz, String url, String xpath) {
        this.clazz = clazz;
        this.url = url;
        this.xpath = xpath;
    }

    public Class getClazz() {
        return clazz;
    }

    public String getUrl() {
        return url;
    }

    public String getXpath() {
        return xpath;
    }
}
