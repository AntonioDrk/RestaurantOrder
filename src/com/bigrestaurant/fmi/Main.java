package com.bigrestaurant.fmi;

import com.bigrestaurant.fmi.services.FileTextService;
import com.bigrestaurant.fmi.services.InterogationService;
import com.bigrestaurant.fmi.services.OrderService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //initialiseFiles();
        InterogationService interogationService = InterogationService.getInstance();
        OrderService orderService = OrderService.getInstance();

        interogationService.startUserInterface();
    }

    public static void initialiseFiles(){
        ArrayList<String> foodItemsToWrite =  new ArrayList<>();
        foodItemsToWrite.add("Food Item 1,213,14/06/2005,360,800");
        foodItemsToWrite.add("Food Item 2,23,17/06/2001,120,50");

        ArrayList<String> liquidItemsToWrite =  new ArrayList<>();
        liquidItemsToWrite.add("Liquid Item 1,14,17/06/2005,120,200,true,0.4");
        liquidItemsToWrite.add("Liquid Item 1,14,17/06/2005,120,200,false");

        FileTextService.getInstance().writeBulkTextToFile(foodItemsToWrite,"./files/foodItems.csv");
        FileTextService.getInstance().writeBulkTextToFile(liquidItemsToWrite, "./files/liquidItems.csv");

    }
}
