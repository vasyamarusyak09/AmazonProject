package com.atqa2020.framework.utils;

import com.atqa2020.framework.dictionary.AmazonURLs;
import com.atqa2020.framework.dictionary.SearchTerms;

import java.lang.reflect.Method;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "getTestData")
    public static Object[][] getTestData(Method method) {
        switch (method.getName()) {
            case "mainPageURLs":
                return getAllURLs();
            case "amazonURLsTest":
                return getAllSearchTerms();
            default:
                return null;
        }
    }


    public static Object[][] getAllSearchTerms() {

        Object[][] searchTerms = new Object[4][1];
        searchTerms[0][0] = SearchTerms.LAPTOP.getSearchTerm();
        searchTerms[1][0] = SearchTerms.TABLET.getSearchTerm();
        searchTerms[2][0] = SearchTerms.VACUUM_CLEANER.getSearchTerm();
        searchTerms[3][0] = SearchTerms.MOUSE.getSearchTerm();
        return searchTerms;
    }

    public static Object[][] getAllURLs() {

        Object[][] urls = new Object[3][3];
        urls[0][0] = AmazonURLs.ABOUT_US_URL.getClazz();
        urls[0][1] = AmazonURLs.ABOUT_US_URL.getUrl();
        urls[0][2] = AmazonURLs.ABOUT_US_URL.getXpath();
        urls[1][0] = AmazonURLs.CAREERS_URL.getClazz();
        urls[1][1] = AmazonURLs.CAREERS_URL.getUrl();
        urls[1][2] = AmazonURLs.CAREERS_URL.getXpath();
        urls[2][0] = AmazonURLs.SELL_ON_AMAZON_URL.getClazz();
        urls[2][1] = AmazonURLs.SELL_ON_AMAZON_URL.getUrl();
        urls[2][2] = AmazonURLs.SELL_ON_AMAZON_URL.getXpath();
        return urls;
    }
}
