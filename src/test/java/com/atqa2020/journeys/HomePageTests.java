package com.atqa2020.journeys;

import com.atqa2020.BaseTest;
import com.atqa2020.framework.dictionary.AmazonURLs;
import com.atqa2020.framework.utils.Helper;
import com.atqa2020.framework.utils.DataProvider;
import com.atqa2020.listeners.TestListener;
import com.atqa2020.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.ArrayList;

@Listeners(TestListener.class)
public class HomePageTests extends BaseTest {

    private String acceptCookiesButtonLocator = "//input[@id='sp-cc-accept']";
    private String sheetName = "URLsTest";
    private HomePage homePage;
    private ArrayList<String> results = new ArrayList<>();

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        if (isElementDisplayed(By.xpath(acceptCookiesButtonLocator))) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
        homePage = new HomePage(driver);
    }

    @org.testng.annotations.DataProvider(name = "getURLs")
    public Object[][] getURLs() {
        return DataProvider.getAllURLs();
    }

    @org.testng.annotations.DataProvider(name = "getURLsExcel")
    public Object[][] getData() {
        if (excelReader == null) {
            getExcelReader();
        }

        int rows = excelReader.getRowCount(sheetName);
        int columns = excelReader.getColumnCount(sheetName);

        Object[][] data = new Object[rows-1][columns];
        for (int rowNum = 2; rowNum <= rows; rowNum++){
            for (int colNum = 0; colNum < columns; colNum++){
                data[rowNum-2][colNum] = excelReader.getCellData(sheetName, colNum, rowNum-1);
            }
        }
        return data;
    }


    @Test(groups = "main", dataProvider = "getTestData", dataProviderClass = DataProvider.class)
    public void mainPageURLs(Class clazz, String url, String xpath) throws Exception {
        //Given user navigates to the expected page through the footer
        homePage.navigateToPage(clazz, xpath);

        //Then page URL constructed as required
        Assert.assertTrue(isURLValid(url), "URL is not valid");
    }

    @Test(groups = {"main", "excel"}, dataProvider = "getURLsExcel")
    public void amazonURLsTest(String key, String url, String xpath) throws Exception {

        //Given user navigates to the expected page through the footer
        homePage.navigateToPage(returnClass(key), xpath);

        //Then page URL constructed as required
        Assert.assertTrue(isURLValid(url), "URL is not valid");
    }

    @AfterMethod(onlyForGroups = "excel")
    private void gatherResults(ITestResult result) {
        if(result.getStatus() == ITestResult.SUCCESS){
            results.add("passed");
        } else if(result.getStatus() == ITestResult.FAILURE){
            results.add("failed");
        } else if(result.getStatus() == ITestResult.SKIP ){
            results.add("skipped");
        }
    }

    @AfterClass(groups = "excel")
    private void publishResults() {
        if (excelReader != null) {
            excelReader.setCellData(sheetName,3, results);
        }
    }

    private Class returnClass(String key) {
        switch(key){
            case "ABOUT_US_URL":
                return AmazonURLs.ABOUT_US_URL.getClazz();
            case "CAREERS_URL":
                return AmazonURLs.CAREERS_URL.getClazz();
            case "SELL_ON_AMAZON_URL":
                return AmazonURLs.SELL_ON_AMAZON_URL.getClazz();
            default:
                Helper.Logger.LogInfo("No such class");
                return null;
        }
    }
}
