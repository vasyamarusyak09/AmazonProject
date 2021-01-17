package com.atqa2020.pages;

import com.atqa2020.framework.utils.Helper;
import com.atqa2020.framework.utils.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Page {

    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public Page(final RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    protected <T extends Page>T clickOnElement(By selector, Class<T> clazz) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            driver.findElement(selector).click();
            return PageFactory.newPage(driver, clazz);
        } catch (Exception ex) {
            Helper.Logger.LogError("Element is not clickable", ex);
            return null;
        }
    }

    protected <T extends Page>T setText(By selector, String text, Class<T> clazz) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            driver.findElement(selector).sendKeys(text);
            return PageFactory.newPage(driver, clazz);
        } catch (Exception ex) {
            Helper.Logger.LogError("Can't send keys", ex);
            return null;
        }
    }

    protected WebElement getElement(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return driver.findElement(selector);
        } catch (Exception ex) {
            Helper.Logger.LogError("Element is not present", ex);
            return null;
        }
    }

    protected List<WebElement> getElements(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return driver.findElements(selector);
        } catch (Exception ex) {
            Helper.Logger.LogError("Elements are not present", ex);
            return null;
        }
    }
}
