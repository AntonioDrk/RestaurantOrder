package com.bigrestaurant.fmi.services;
import com.bigrestaurant.fmi.model.Item;
import com.bigrestaurant.fmi.model.Order;

import java.util.ArrayList;

public class OrderService {
    private static OrderService instance = new OrderService();
    private static ArrayList<Order> listOfOrders = new ArrayList<>();

    private OrderService() {
        System.out.println("--- OrderService Initialization ---");
    }

    public void displayCostOfOrder(Integer orderIndex){
        if(orderIndex - 1 < listOfOrders.size()){
            System.out.println("\n\nCost of order no [" + orderIndex + "] is : " + listOfOrders.get(orderIndex-1).getTotalPrice() + "\n\n");
        }else{
            System.out.println("\n\nThe entered number is out of bounds, try again.\n\n");
        }
    }

    public void displayOrders(){
        System.out.println("\n\n---- Orders ----\n");
        for(Order order:listOfOrders){
            Integer index = listOfOrders.indexOf(order) + 1;
            System.out.println("[" + index + "] " + order.toString());
        }
        System.out.println("\n----        ----\n\n");
    }

    public void placeOrder(ArrayList<Item> itemsOrdered){
        Order currentOrder = new Order(itemsOrdered);
        listOfOrders.add(currentOrder);
    }

    public static OrderService getInstance(){
        return instance;
    }
}
