package com.atqa2020.practice;

import java.util.Date;

public abstract class BasePage {

    protected abstract void printTitle();

    public long returnTime() {
        return new Date().getTime();
    }

    public void clickOnElement(String xpath) {
        System.out.println("Clicking on " + xpath);
    }

    public void searchItem(String itemName) {

    }
}
