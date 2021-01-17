package com.atqa2020.practice;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @Override
    public void printTitle() {
        System.out.println("Base Page title");;
    }

    public void printTime() {
        System.out.println(returnTime());
    }

    public void clickOnElementFromChild(String xpath) {
        super.clickOnElement(xpath);
    }

    public void findItem(String title) {
        Header header = new Header();
        header.searchText(title);
    }

    public void arraySample() {

        String[] myArray = new String[10];

        myArray[0] = "1";

        ArrayList myList = new ArrayList();


        myList.add(2);
        myList.add("String");
        myList.add(1.3);


        System.out.println();

    }
}
