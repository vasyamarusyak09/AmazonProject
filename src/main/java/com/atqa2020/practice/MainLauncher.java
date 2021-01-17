package com.atqa2020.practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MainLauncher {

    static int temp = 1;

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Constructor example
        ConstructorsExample constructorsExample = new ConstructorsExample();
        constructorsExample.printHello();

        //Class variable example
        printTitle();


        constructorsExample.printVariable(5);

        HomePage homePage = new HomePage();
        homePage.clickOnElementFromChild("yet another xpath");

        HomePage homePage1 = new HomePage();
        homePage1 = homePage;

        HomePage basePage = new HomePage();
        basePage.clickOnElementFromChild("sample");


        homePage.printTitle();

//        ContactsPage contactsPage = new ContactsPage();
//        contactsPage.printTitle();
//
//        System.out.println(homePage1 != homePage);
//
//        int a = 10;
//        int b = 0;
//
//        Integer abc= 10;
//
//        String smth = "10";
//
//        b = Integer.getInteger(smth);
//
//
//
//        String result;
//
//        result = (a == b) ? "yes" : "no";
//
//        System.out.println(result + "- final result " + "-" + "end!");
//
//        System.out.println(homePage1 instanceof HomePage);


//        if (a == b) {
//            System.out.println("they are equal");
//        } else {
//            System.out.println("a and b aren't equal");
//        }
//
//        System.out.println("they're not equal");
//
//        if (a == 0) {
//            System.out.println("if/else - they are equal");
//        } else if (a == 1) {
//            System.out.println("if/else - they are not equal");
//        } else if (a == 3){
//            System.out.println("everything else");
//        }
//
//        if (a == b) {
//            System.out.println("nested if - they are equal");
//            if (a == 0) {
//                System.out.println("a == 0");
//            }
//        }

//        switch (result) {
//            case "yes" :
//                System.out.println("it's yes");
//                break;
//            case "no" :
//                System.out.println("it's no");
//                break;
//            default:
//                System.out.println("outside of range");
//                break;
//        }

        //navigate
        //click
        //get title
        //get text

//        Assert.that(a == b, "a and b aren't equal");


        int[] arrayOfInts = {1, 2, 3};
        int[] newArrayOfInts = {1, 2, 3};

        int[] cloneArrayOfInts = arrayOfInts.clone();

//        arrayOfInts[0] = 4;

        boolean result = Arrays.equals(arrayOfInts, cloneArrayOfInts);

        System.out.println("First element of the array - " + arrayOfInts[2]);
        System.out.println("Length of the array - " + arrayOfInts.length);

        System.out.println("Arrays are equal - " + result);

        ArrayList listOfStrings = new ArrayList<>();

        LinkedList listLinked = new LinkedList();


        listOfStrings.add(0, "test");
        listOfStrings.add(1);
        listOfStrings.add(2);
        listOfStrings.add(3);
        listOfStrings.add(2);
        listOfStrings.add(4);
        listOfStrings.add(1);

        listOfStrings.get(0);


        int b = Arrays.asList(arrayOfInts).size();

        listOfStrings.toArray();

        System.out.println("List size - " + b);
        System.out.println("Index for the first element occurence  - " + listOfStrings.lastIndexOf(5));

        for (int i = 0; i < 5; i++) {
            System.out.println("Current index - " + listOfStrings.get(i));
        }

        for (Object element : listOfStrings) {
            System.out.println("List - " + element.toString());
        }

        listOfStrings.iterator().hasNext();

        int c = 0;
        int d = 10;

        while (listOfStrings.size() > c) {
            System.out.println("while loop - " + listOfStrings.get(c));
//            c++;
        }

        do {
            System.out.println("do while loop - " + d);
            d++;
        } while (listOfStrings.size() > d);

        System.out.println("d - " + d);

    }

    public static void printTitle() {


        int local = temp;

        System.out.println(ConstructorsExample.TITLE);

    }

//    public <T extends BasePage>T isObjectCorrect(Class<T> clazz, Object input) {
//        return input instanceof clazz;
//    }
}
