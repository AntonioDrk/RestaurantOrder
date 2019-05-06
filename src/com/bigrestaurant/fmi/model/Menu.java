package com.bigrestaurant.fmi.model;
import com.bigrestaurant.fmi.services.FileTextService;

import java.util.ArrayList;



public class Menu {
    private static ArrayList<Item> menuList = new ArrayList<>();
    private static Menu instance = new Menu();

    private Menu(){
        System.out.println("--- Menu Initialization ---");

        ArrayList<FoodItem> foodItems = FileTextService.getInstance().readFoodItemsFromFile("./files/foodItems.csv");
        ArrayList<LiquidItem> liquidItems = FileTextService.getInstance().readLiquidItemsFromFile("./files/liquidItems.csv");

        menuList.addAll(foodItems);
        menuList.addAll(liquidItems);
    }

    public ArrayList<Item> getMenuList(){
        return menuList;
    }

    public void displayItems(){
        System.out.println("\n\n----- Menu Items -----\n");
        for (Item item:menuList){

            Integer indexOfItem = menuList.indexOf(item)+1;
            System.out.println("[" + indexOfItem + "] " + item.toString());
        }
        System.out.println("\n-----            -----\n\n");
    }

    public static Menu getInstance(){
        return instance;
    }
}
