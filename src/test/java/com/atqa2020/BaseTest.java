package com.atqa2020;

import com.atqa2020.framework.utils.ExcelReader;
import com.atqa2020.framework.utils.Helper;
import com.atqa2020.framework.utils.PageNavigator;
import com.atqa2020.listeners.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
import static org.apache.commons.lang3.SystemUtils.IS_OS_LINUX;

@Listeners(TestListener.class)
public abstract class BaseTest {

    private static final String DEFAULT_ENV_PROPERTIES_FILE_PATH = "src/test/resources/test.properties";
    private static final String DEFAULT_ENV_REMOTE_PROPERTIES_FILE_PATH = "src/test/resources/remote.properties";
    private static String EXCEL_DATA_FILE_PATH =  "src/test/resources/TestData.xlsx";
    protected RemoteWebDriver driver = null;
    private static Properties properties;
    protected static ExcelReader excelReader;
    protected WebDriverWait wait;
    protected PageNavigator pageNavigator;

    static {
        properties = new Properties();
        loadPropertiesFromFile(DEFAULT_ENV_PROPERTIES_FILE_PATH);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
//TODO write better code please
        if (IS_OS_MAC) {
            if (getBrowser().equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeouts()));
//        driver.manage().window().maximize();
            } else if (getBrowser().equals("firefox")) {
                System.setProperty("webdriver.firefox.driver", "drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeouts()));
            }
        } else if (IS_OS_LINUX) {
            if (getBrowser().equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-3");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--headless"); //should be enabled for Jenkins
                options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
                options.addArguments("--window-size=1920x1080"); //should be enabled for Jenkins
                driver = new ChromeDriver(options);
                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeouts()));
//        driver.manage().window().maximize();
            } else if (getBrowser().equals("firefox")) {
                System.setProperty("webdriver.firefox.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeouts()));
            }
        } else if (IS_OS_WINDOWS) {
            if (getBrowser().equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
                driver = new ChromeDriver();
                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeouts()));
//        driver.manage().window().maximize();
            } else if (getBrowser().equals("firefox")) {
                System.setProperty("webdriver.firefox.driver", "drivers//geckodriver.exe");
                driver = new FirefoxDriver();
                this.wait = new WebDriverWait(driver, Integer.parseInt(getTimeouts()));
            }
        }
        pageNavigator = new PageNavigator(driver, getMainUrl());
        driver.get(getMainUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        Helper.Logger.LogInfo("Driver teardown");
    }

    protected boolean isElementDisplayed(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return driver.findElement(selector).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    protected boolean isURLValid(String expectedURL) {
        return driver.getCurrentUrl().contains(expectedURL);
    }

    protected ExcelReader getExcelReader() {
        if (excelReader == null) {
            this.excelReader = new ExcelReader(EXCEL_DATA_FILE_PATH);
        }
        return excelReader;
    }

    protected String getBrowser() {
        return getProperty("test.browser");
    }

    protected String getTimeouts() {
        return getProperty("test.timeout");
    }

    protected String getMainUrl() {
        String result;
        if (getProperty("test.isLocal").equals("true")) {
            result = properties.getProperty("test.mainUrl");
        } else {
            result = properties.getProperty("test.qaUrl");
        }
        return (result != null) ? result.trim() : null;
    }

    protected String getProperty(String key) {
        String result = properties.getProperty(key);
        return (result != null) ? result.trim() : null;
    }

    private static void loadPropertiesFromFile(String propertiesFilePath) {
        try {
            InputStream propertiesStream;
            propertiesStream = new FileInputStream(new File(propertiesFilePath).getPath());
            properties.load(propertiesStream);
        } catch (Exception ex) {
            Helper.Logger.LogError("Property file wasn't loaded", ex);
        }
    }
}
