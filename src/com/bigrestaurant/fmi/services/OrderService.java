package com.bigrestaurant.fmi.services;
import com.bigrestaurant.fmi.model.Item;
import com.bigrestaurant.fmi.model.Menu;
import com.bigrestaurant.fmi.model.Order;

import java.util.ArrayList;

public class OrderService {
    private static OrderService instance = new OrderService();
    private static Order[] listOfOrders = new Order[5];

    private OrderService() {
        System.out.println("--- OrderService Initialization ---");

        ArrayList<Item> menuList = Menu.getInstance().getMenuList();

        ArrayList<Item> itemsToOrder = new ArrayList<Item>();
        itemsToOrder.add(menuList.get(1));
        itemsToOrder.add(menuList.get(2));
        itemsToOrder.add(menuList.get(4));
        itemsToOrder.add(menuList.get(5));

        Order order1 = new Order(itemsToOrder);
        Order order2 = new Order(itemsToOrder);

        System.out.println("Total price for order " + order1.getOrderId() + " is: " + order1.getTotalPrice());
        System.out.println("Total price for order " + order2.getOrderId() + " is: " + order2.getTotalPrice());
    }

    public static OrderService getInstance(){
        return instance;
    }
}
