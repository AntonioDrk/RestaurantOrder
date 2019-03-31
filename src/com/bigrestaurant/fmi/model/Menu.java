package com.bigrestaurant.fmi.model;

import java.util.ArrayList;

public class Menu {
    private static ArrayList<Item> menuList = new ArrayList<>();
    private static Menu instance = new Menu();

    private Menu(){
        System.out.println("--- Menu Constructor ---");
        Date testDate = new Date("14","06","2015");
        Price testPrice = new Price(213f);
        Price testPriceDiscount = new Price(213f, 0.5f);

        menuList.add(new FoodItem("Food Item 1", testPrice, testDate,360,800f));
        menuList.add(new FoodItem("Food Item 2", testPrice, testDate,143,560f));

        menuList.add(new FoodItem("Food Item 3", testPriceDiscount, testDate,3456,2000f));
        menuList.add(new FoodItem("Food Item 4", testPriceDiscount, testDate,200,300f));

        menuList.add(new LiquidItem("Liquid Item 1", testPrice, testDate,180, 200f));
        menuList.add(new LiquidItem("Liquid Item 2 Alcoholic", testPrice, testDate,120, 200f, true, 0.4f));


    }

    public ArrayList<Item> getMenuList(){
        return menuList;
    }

    public static Menu getInstance(){
        return instance;
    }
}
